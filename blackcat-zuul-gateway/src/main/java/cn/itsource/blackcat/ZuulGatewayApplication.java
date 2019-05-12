package cn.itsource.blackcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wgb
 * @version V1.0
 * @className ZuulGatewayApplication
 * @description TODO
 * @date 2019/5/11 0011
 */

@SpringBootApplication
@EnableZuulProxy //网关
@EnableEurekaClient
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class,args);
    }

}
