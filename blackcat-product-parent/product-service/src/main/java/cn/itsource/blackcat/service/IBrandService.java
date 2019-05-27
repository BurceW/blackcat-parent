package cn.itsource.blackcat.service;

import cn.itsource.blackcat.domain.Brand;
import cn.itsource.blackcat.query.BrandQuery;
import cn.itsource.blackcat.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author wgb
 * @since 2019-05-16
 */
public interface IBrandService extends IService<Brand> {

    PageList<Brand> getByQuery(BrandQuery query);

    Map<String,Object> loadByPrductTypeId(Long productTypeId);
}
