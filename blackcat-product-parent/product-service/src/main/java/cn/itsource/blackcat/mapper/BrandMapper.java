package cn.itsource.blackcat.mapper;

import cn.itsource.blackcat.domain.Brand;
import cn.itsource.blackcat.query.BrandQuery;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author wgb
 * @since 2019-05-16
 */
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {

    IPage<Brand> selectByQuery(Page<Brand> page, @Param("query") BrandQuery query);

    IPage<Brand> selectByWrapper(Page<Brand> page,@Param(Constants.WRAPPER) Wrapper wrapper);

}
