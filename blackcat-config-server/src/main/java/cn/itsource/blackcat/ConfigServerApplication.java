package cn.itsource.blackcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author wgb
 * @version V1.0
 * @className ConfigServerApplication
 * @description TODO
 * @date 2019/5/12 0012
 */
@SpringBootApplication
@EnableConfigServer //配置中心服务端
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }


}
