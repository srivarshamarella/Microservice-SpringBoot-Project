package com.ribbon.RibbonLoadBalancerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.ribbon.RibbonLoadBalancerDemo.Configuration.RibbonConfiguration;

@SpringBootApplication
@RibbonClient(name = "VIRTUSA-RIBBON", configuration=RibbonConfiguration.class)
public class RibbonLoadBalancerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonLoadBalancerDemoApplication.class, args);
	}
@Bean 
public RestTemplate RestTemplate() {
	return new RestTemplate();
}
}
