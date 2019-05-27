package cn.itsource.blackcat.controller;

import cn.itsource.blackcat.util.RedisUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wgb
 * @version V1.0
 * @className RedisController
 * @description TODO
 * @date 2019/5/17 0017
 */
@RestController
public class RedisController {

    /**
     * 添加数据到redis
     * @param key
     * @param value
     */
    @PostMapping("/redis")
    public void set(String key,String value){
        RedisUtils.INSTANCE.set(key, value);
    }

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    @GetMapping("/redis")
    public String get(String key){
        return RedisUtils.INSTANCE.get(key);
    }

}
