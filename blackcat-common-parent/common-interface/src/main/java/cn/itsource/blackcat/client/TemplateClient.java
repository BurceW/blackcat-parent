package cn.itsource.blackcat.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("BLACKCAT-COMMON")
public interface TemplateClient {

    @PostMapping("/page")
    void createStaticPage(@RequestBody Map<String, Object> params);

}
