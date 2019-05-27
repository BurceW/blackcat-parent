package cn.itsource.blackcat.mapper;

import cn.itsource.blackcat.domain.Product;
import cn.itsource.blackcat.query.ProductQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品 Mapper 接口
 * </p>
 *
 * @author wgb
 * @since 2019-05-20
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    IPage<Product> selectByQuery(Page<Product> page,@Param("query")ProductQuery query);

    /**
     * 上架 修改上架时间和状态
     */
    void onSale(@Param("ids") List<Long> ids, @Param("onSaleTime") Long onSaleTime);

    /**
     * 下架
     * @param ids
     * @param offSaleTime
     */
    void offSale(@Param("ids")List<Long> ids,@Param("offSaleTime") long offSaleTime);
}
