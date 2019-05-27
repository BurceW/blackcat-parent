package cn.itsource.blackcat;

import cn.itsource.blackcat.domain.ProductDoc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wgb
 * @version V1.0
 * @className EsTest
 * @description TODO
 * @date 2019/5/23 0023
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonApplication.class)
public class EsTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testEs(){
        elasticsearchTemplate.deleteIndex("blackcat");
        elasticsearchTemplate.createIndex("blackcat");
        elasticsearchTemplate.putMapping(ProductDoc.class);
    }
}
