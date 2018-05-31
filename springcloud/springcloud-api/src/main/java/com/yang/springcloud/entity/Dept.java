package com.yang.springcloud.entity;

import java.io.Serializable;

import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Helper;
import lombok.extern.java.Log;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{
	
	private String dname;
	private String deptNo;
	private String db_source;
	
	
	public static void main(String[] args) {
		Dept dept = new Dept();
	}
	
}
