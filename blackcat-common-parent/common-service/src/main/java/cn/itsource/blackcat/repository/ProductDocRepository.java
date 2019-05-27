package cn.itsource.blackcat.repository;

import cn.itsource.blackcat.domain.ProductDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author wgb
 * @version V1.0
 * @className ProductDocRepository
 * @description TODO
 * @date 2019/5/23 0023
 */
public interface ProductDocRepository extends ElasticsearchRepository<ProductDoc,Long>{
}
