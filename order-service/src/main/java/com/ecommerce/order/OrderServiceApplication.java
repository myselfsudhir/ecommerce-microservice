
package com.ecommerce.order;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {
 public static void main(String[] args){
  SpringApplication.run(OrderServiceApplication.class,args);
 }
}
