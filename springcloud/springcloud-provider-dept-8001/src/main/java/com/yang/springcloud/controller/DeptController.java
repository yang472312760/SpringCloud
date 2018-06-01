package com.yang.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springcloud.entity.Dept;
import com.yang.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return deptService.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		return deptService.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		System.out.println(deptService.list());
		return deptService.list();
	}
	
	@RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
	public Object discovery() {
		List<String> services = client.getServices();
		System.out.println("****" + services);
		
		List<ServiceInstance> instances = client.getInstances("SERVICECLOUD-DEPT");
		for (ServiceInstance serviceInstance : instances) {
			System.out.println(serviceInstance.getServiceId() + "\n" + serviceInstance.getHost() + "\n" + serviceInstance.getPort()+"\n" + serviceInstance.getUri());;
		}
		return this.client;
	}
	
}
