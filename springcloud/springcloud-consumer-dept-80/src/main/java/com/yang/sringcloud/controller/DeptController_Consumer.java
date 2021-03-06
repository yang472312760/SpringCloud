package com.yang.sringcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yang.springcloud.entity.Dept;

@RestController
public class DeptController_Consumer {
	
	private static final String REST_URL_PREFIX = "http://SERVICECLOUD-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public Boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add" ,dept,Boolean.class );
	}
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/" + id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> get() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
	
}
