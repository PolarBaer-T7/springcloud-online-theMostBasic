package cn.kgc.zhengzeyan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//Ribbon 和 Eureka 整合之后，客户端可以直接调用。不用关心IP地址和端口号。
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class DeptConsumer_80 {


    public static void main(String[] args) {

        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
