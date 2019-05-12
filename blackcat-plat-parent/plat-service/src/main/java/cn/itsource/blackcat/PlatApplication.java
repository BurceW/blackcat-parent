package cn.itsource.blackcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wgb
 * @version V1.0
 * @className PlatApplication
 * @description TODO
 * @date 2019/5/11 0011
 */
@SpringBootApplication
@EnableEurekaClient
public class PlatApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatApplication.class,args);
    }

}
