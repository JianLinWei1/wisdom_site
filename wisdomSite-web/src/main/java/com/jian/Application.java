package com.jian;




import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.scheduling.annotation.EnableAsync;





@ComponentScan
@SpringBootApplication(scanBasePackages = {"com.jian"} )
@EnableAsync
@MapperScan("com.jian.dao")
public class Application {
  public static void main(String[] args) {
	
	SpringApplication.run(Application.class);
}
  
  
  
  
  
}
