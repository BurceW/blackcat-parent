package cn.itsource.blackcat.client;

import cn.itsource.blackcat.domain.ProductDoc;
import cn.itsource.blackcat.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wgb
 * @version V1.0
 * @className ElasticSearchClient
 * @description es接口服务
 * @date 2019/5/23 0023
 */
@FeignClient("BLACKCAT-COMMON")
public interface ElasticSearchClient {

    /**
     * 保存到es
     * @param productDoc
     * @return
     */
    @PostMapping("/es/save")
    AjaxResult save(@RequestBody ProductDoc productDoc);

    /**
     * 批量保存
     * @param productDocs
     * @return
     */
    @PostMapping("/es/saveBatch")
    AjaxResult saveBatch(@RequestBody List<ProductDoc> productDocs);

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/es/delete")
    AjaxResult delete(@RequestParam("id") Long id);

    /**
     * 批量删除
     * @param productDocs
     * @return
     */
    @PostMapping("/es/deleteBatch")
    AjaxResult deleteBatch(@RequestBody List<ProductDoc> productDocs);

    /**
     * 批量id删除
     * @param ids
     * @return
     */
    @PostMapping("/es/deleteBatchByIds")
    AjaxResult deleteBatchByIds(@RequestBody List<Long> ids);
}
