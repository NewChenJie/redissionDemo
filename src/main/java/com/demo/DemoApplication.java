package com.demo;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
@Bean
 public Redisson redisson() {
	Config config = new Config();
	config.useSentinelServers().addSentinelAddress("redis://127.0.0.0:6379").setDatabase(0);
	return (Redisson) Redisson.create(config);
 }
}

