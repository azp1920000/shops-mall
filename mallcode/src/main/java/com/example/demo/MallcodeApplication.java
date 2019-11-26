package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@MapperScan(value = "com.example.demo.mallshop.mapper")
public class MallcodeApplication {

	public static void main(String[] args) {

		SpringApplication.run(MallcodeApplication.class, args);
	}

}
