package cn.itsource.blackcat.service;

import cn.itsource.blackcat.domain.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author wgb
 * @since 2019-05-16
 */
public interface IProductTypeService extends IService<ProductType> {

    List<ProductType> loadTreeData();

    void generateStaticPage();

    String getPathById(Long id);

    List<Map<String,Object>> loadCrumbs(Long productTypeId);


}
