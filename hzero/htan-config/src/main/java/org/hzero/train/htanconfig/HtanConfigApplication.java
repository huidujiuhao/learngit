package org.hzero.train.htanconfig;

import org.hzero.autoconfigure.config.EnableHZeroConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableHZeroConfig
@EnableEurekaClient
@SpringBootApplication
public class HtanConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtanConfigApplication.class, args);
    }

}
