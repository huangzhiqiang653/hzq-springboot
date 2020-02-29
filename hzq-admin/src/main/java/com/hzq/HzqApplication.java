package com.hzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author 黄智强
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.hzq.*.mapper")
public class HzqApplication {
    public static void main(String[] args) {
        SpringApplication.run(HzqApplication.class, args);
        System.out.println("系统启动成功\n");
    }
}
