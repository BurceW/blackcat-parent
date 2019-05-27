package cn.itsource.blackcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wgb
 * @version V1.0
 * @className ProductApplication
 * @description TODO
 * @date 2019/5/16 0016
 */
@SpringBootApplication
@EnableEurekaClient  //eureka客户端
@EnableSwagger2      //swagger生成接口文档
@EnableFeignClients(basePackages = "cn.itsource.blackcat.client")
//@ComponentScan("cn.itsource.blackcat.client")//扫描到返回托底数据的工厂
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }

}
