package cn.itsource.redis;

import cn.itsource.blackcat.ProductApplication;
import cn.itsource.blackcat.client.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wgb
 * @version V1.0
 * @className RedisTest
 * @description TODO
 * @date 2019/5/18 0018
 */
@SpringBootTest(classes = ProductApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisClient redisClient;


    @Test
    public void testRedisSet()throws Exception{
        redisClient.set("username1","admin1");
    }

    @Test
    public void testRedisGet()throws Exception{
        System.out.println(redisClient.get("username"));
    }


}
