package cn.itsource.blackcat.service.impl;

import cn.itsource.blackcat.client.RedisClient;
import cn.itsource.blackcat.client.TemplateClient;
import cn.itsource.blackcat.domain.ProductType;
import cn.itsource.blackcat.mapper.ProductTypeMapper;
import cn.itsource.blackcat.service.IProductTypeService;
import cn.itsource.blackcat.util.StrUtils;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author wgb
 * @since 2019-05-16
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private TemplateClient templateClient;

    /**
     * 生成静态化首页
     */
    @Override
    public void generateStaticPage() {
        //模板   数据   目标文件的路径
        //路径问题最好不要硬编码，可以写到属性文件或者配置文件中，再读入

        //根据product.type.vm模板生成 product.type.vm.html  静态化商品类型
        String templatePath = "D:\\javaKJ\\IEDA\\JetBrains\\IDEA-workspace\\blackcat\\blackcat-parent\\blackcat-product-parent\\product-service\\src\\main\\resources\\template\\product.type.vm";
        String targetPath = "D:\\javaKJ\\IEDA\\JetBrains\\IDEA-workspace\\blackcat\\blackcat-parent\\blackcat-product-parent\\product-service\\src\\main\\resources\\template\\product.type.vm.html";
        List<ProductType> productTypes = loadDateTree();
        Map<String,Object> params = new HashMap<>();
        params.put("model",productTypes);
        params.put("templatePath",templatePath);
        params.put("targetPath",targetPath);
        templateClient.createStaticPage(params);

        //再根据home.vm生成home.html  静态化主页
        templatePath = "D:\\javaKJ\\IEDA\\JetBrains\\IDEA-workspace\\blackcat\\blackcat-parent\\blackcat-product-parent\\product-service\\src\\main\\resources\\template\\home.vm";
        targetPath = "D:\\javaKJ\\IEDA\\JetBrains\\IDEA-workspace\\blackcat\\ecommerce\\home.html";
        params = new HashMap<>();

        Map<String,Object> model = new HashMap<>();
        model.put("staticRoot","D:\\javaKJ\\IEDA\\JetBrains\\IDEA-workspace\\blackcat\\blackcat-parent\\blackcat-product-parent\\product-service\\src\\main\\resources\\");
        params.put("model",model);
        params.put("templatePath",templatePath);
        params.put("targetPath",targetPath);
        templateClient.createStaticPage(params);

    }

    @Override
    public List<ProductType> loadTreeData() {
        //1.尝试从reids中获取
        String productTypesStr = redisClient.get("productTypes");
        if (StringUtils.isEmpty(productTypesStr)){

            //从数据库中获取
            List<ProductType> productTypes = loadDateTree();
            //存到redis中
            String jsonString = JSONArray.toJSONString(productTypes);
            redisClient.set("productTypes", jsonString);
            return productTypes;
        }
        //转换redis的数据
        List<ProductType> productTypes = JSONArray.parseArray(productTypesStr, ProductType.class);
        return productTypes;
    }

    /**
     * 1、递归：
     * （1）自己调用自己
     * （2）要有出口
     * @return
     */
    private List<ProductType> loadDataTree(Long pid){
        //根据父id查询子类型
        List<ProductType> children = baseMapper.selectList(new QueryWrapper<ProductType>().eq("pid", pid));
        //递归的出口
        if(children==null||children.size()==0){
            return null;
        }
        for (ProductType productType : children) {
            //对子进行循环，调用自己继续查询子的子类型
            List<ProductType> c = loadDataTree(productType.getId());
            //将所有的孙子类型放入到子的children属性中
            productType.setChildren(c);
        }
        return children;
    }

    /**
     * 循环
     * @return
     */
    private List<ProductType> loadDateTree(){

        List<ProductType> productTypes = baseMapper.selectList(null);
        //放到map中
        Map<Long,ProductType> map = new HashMap<>();
        for (ProductType productType : productTypes) {
            map.put(productType.getId(), productType);
        }
        //用list放所有的一级菜单
        List<ProductType> list = new ArrayList<>();

        for (ProductType productType : productTypes) {
            //父级菜单
            if (productType.getPid() == 0){
                list.add(productType);
            }else {
                map.get(productType.getPid()).getChildren().add(productType);
            }
        }
        return list;
    }


    //=====================重写增删改，同步redis缓存，同步生成静态页面==================================
    @Override
    public boolean save(ProductType entity) {
        //先执行保存
        boolean result = super.save(entity);
        sychornizedOperate();
        return result;
    }

    @Override
    public boolean removeById(Serializable id) {
        boolean result = super.removeById(id);
        sychornizedOperate();
        return result;
    }

    @Override
    public boolean updateById(ProductType entity) {
        boolean result = super.updateById(entity);
        sychornizedOperate();
        return result;
    }


    private void updateRedis(){
        List<ProductType> productTypes = loadDateTree();
        //转成json字符串缓存到redis中
        String jsonString = JSONArray.toJSONString(productTypes);
        redisClient.set("productTypes",jsonString);
    }

    //=====================结束==================================

    /**
     * 只要是增删改操作，都要同步去做两件事情
     * （1）同步redis缓存
     * （2）同步生成静态的主页面
     */
    private void sychornizedOperate(){
        updateRedis();
        generateStaticPage();
    }


    @Override
    public String getPathById(Long id) {
        ProductType productType = baseMapper.selectById(id);
        return productType.getPath();
    }

    /**
     * 加载类型面包屑
     * @param productTypeId
     * @return
     */
    @Override
    public List<Map<String, Object>> loadCrumbs(Long productTypeId) {
        //查询当前类型
        ProductType productType = baseMapper.selectById(productTypeId);
        //获取path路径
        String path = productType.getPath().substring(1);// .1.2.3.
        List<Long> ids = StrUtils.splitStr2LongArr(path, "\\."); // 1,2,30
        List<Map<String,Object>> crumb = new ArrayList<>();//用来存放数据的
        for (Long id : ids) {
            Map<String,Object> map = new HashMap<>();
            //当前类型
            ProductType currentType = baseMapper.selectById(id);
            //当前类型的其他同级别的类型  同pid  排除当前的id
            List<ProductType> otherTypes = baseMapper.selectList(new QueryWrapper<ProductType>()
                    .eq("pid", currentType.getPid()).ne("id", currentType.getId()));
            map.put("currentType",currentType);
            map.put("otherTypes",otherTypes);
            crumb.add(map);
        }
        return crumb;
    }
}
