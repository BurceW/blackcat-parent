package cn.itsource.blackcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wgb
 * @version V1.0
 * @className CommonApplication
 * @description TODO
 * @date 2019/5/17 0017
 */
@SpringBootApplication
@EnableEurekaClient
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class,args);
    }

}
