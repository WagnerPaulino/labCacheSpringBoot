package br.jus.tre_pa.cache.spring.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CacheSpringLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheSpringLabApplication.class, args);
	}
}