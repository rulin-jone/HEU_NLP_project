/**
 * 由于一开始只是连接MySQL建的这个项目，所以名字没改过来，就一直这么用了
 */
package com.example.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 好像不需要加括号这些东西
@SpringBootApplication(scanBasePackages="com.example.mysql")
public class MysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }
}
