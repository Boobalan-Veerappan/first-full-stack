package com.heraizen.aop.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ArithMeticOperation {

	public void sum(int a,int b)
	{
		
		int result = a+b;
		
		System.out.println("Result is Compare : "+ result);
		
	}
	
	public void divide(int a,int b)
	{
		
		int res = a/b;
		
		System.out.println("division Result is : "+ res);
		
	}
	
}
