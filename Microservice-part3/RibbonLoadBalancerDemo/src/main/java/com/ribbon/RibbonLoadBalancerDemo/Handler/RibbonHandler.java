package com.ribbon.RibbonLoadBalancerDemo.Handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;

@Service
public class RibbonHandler {
	@Autowired
	private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Value("${serviceId}")
    private String serviceId;
    @Autowired
    private RestTemplate restTemplate;
	
	public ResponseEntity<?> findCustomers()
	{
		//Available Instances
		//Available endpoints
		List<ServiceInstance> instances= discoveryClient.getInstances(serviceId);
		if((instances==null)||(instances.isEmpty()))
		{
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("No Matching API found");
			
		}
		else
		{
		 //Chosen Instance
		 //chosen endpoint		
		 ServiceInstance  serviceInstance=loadBalancerClient.choose(serviceId);
		 //combine request and end point

         String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/customers";

		  return restTemplate.exchange(url,HttpMethod.GET,null,String.class);
		
		}
		
	}
	}



//Ribbon handler original extra code 
/*
@Service
public class RibbonHandler {
    @Autowired
	private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Value("${serviceId}")
    private String serviceId;
    @Autowired
    private RestTemplate restTemplate;
	
	public ResponseEntity<?> findCustomers()
	{
		//Available Instances
		//Available endpoints
		List<ServiceInstance> instances= discoveryClient.getInstances(serviceId);
		if((instances==null)||(instances.isEmpty()))
		{
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("No Matching API found");
			
		}
		else
		{
		 //Chosen Instance
		 //chosen endpoint		
		 ServiceInstance  serviceInstance=loadBalancerClient.choose(serviceId);
		 //combine request and end point

         String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/customers";

		  return restTemplate.exchange(url,HttpMethod.GET,null,String.class);
		
		}
		
	}
	
	
	
}
*/