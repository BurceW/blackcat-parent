package cn.itsource.blackcat.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wgb
 * @version V1.0
 * @className RedisClient
 * @description TODO
 * @date 2019/5/17 0017
 */

//@FeignClient(value = "AIGOU-COMMON",fallbackFactory = RedisClientFallBackFactory.class)
@FeignClient(value = "BLACKCAT-COMMON")
public interface RedisClient {

    @PostMapping("/redis")
    void set(@RequestParam("key") String key, @RequestParam("value") String value);

    @GetMapping("/redis")
    String get(@RequestParam("key") String key);
}
