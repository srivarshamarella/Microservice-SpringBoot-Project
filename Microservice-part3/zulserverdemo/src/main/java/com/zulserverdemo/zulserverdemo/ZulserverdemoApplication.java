package com.zulserverdemo.zulserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZulserverdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZulserverdemoApplication.class, args);
	}

}
