package cn.itsource.blackcat.service;

import cn.itsource.blackcat.domain.Product;
import cn.itsource.blackcat.domain.Specification;
import cn.itsource.blackcat.query.ProductQuery;
import cn.itsource.blackcat.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author wgb
 * @since 2019-05-20
 */
public interface IProductService extends IService<Product> {

    /**
     * 关键字查询+分页
     * @param query
     * @return
     */
    PageList<Product> getByQuery(ProductQuery query);

    /**
     * 获取商品显示属性
     * @param productId
     * @return
     */
    List<Specification> getViewProperties(Long productId);

    /**
     * 保存商品属性
     * @param specifications
     * @param productId
     */
    void saveViewProperties(List<Specification> specifications,Long productId);

    /**
     * 获取商品sku
     * @param productId
     * @return
     */
    List<Specification> getSkuProperties(Long productId);

    /**
     * 保存sku
     * @param specifications
     * @param productId
     * @param skus
     */
    void saveSkuProperties(List<Specification> specifications, Long productId, List<Map<String,String>> skus);

    /**
     * 商品上架
     * @param ids
     */
    void onSale(List<Long> ids);

    /**
     * 商品下架
     * @param idList
     */
    void offSale(List<Long> idList);
}
