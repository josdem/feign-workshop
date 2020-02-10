package com.jos.dem.feign.workshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableFeignClients
public class RetrofitWorkshopApplication {

  @Value("${github.api.url}")
  private String githubApiUrl;
  @Value("${token}")
  private String token;

  public static void main(String[] args) {
    SpringApplication.run(RetrofitWorkshopApplication.class, args);
  }

}
