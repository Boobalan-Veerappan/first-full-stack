package com.heraizen.ftl.configuration;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data 
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	public String usn;
	public String name;
	public String sem;
	public String email;
	public List<Subject> subject;
	
	
}
