package com.jdvm.ms.categories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.jdvm.ms.categories"})
public class MsCategoriesApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsCategoriesApplication.class, args);
  }
}
