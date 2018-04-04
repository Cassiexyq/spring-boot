package com.nju;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nju.mapper")
public class CassieApplication {
	public static void main(String[] args) {
		SpringApplication.run(CassieApplication.class, args);
	}
}
