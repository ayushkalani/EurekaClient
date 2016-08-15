package com.eureka.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ServiveInstanceController {
	@Autowired
	private DiscoveryClient discoveryClient;

	
	
	
	
	
	@RequestMapping(value = "/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstanceByApplicationName(@PathVariable String applicationName) {
		
		
		List<ServiceInstance> serviceList=this.discoveryClient.getInstances(applicationName);
		
		return  serviceList;
	}
}

@EnableDiscoveryClient
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
