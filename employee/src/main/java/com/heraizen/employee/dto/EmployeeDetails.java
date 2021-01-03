package com.heraizen.employee.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employeeDetails")

public class EmployeeDetails {

	
	@Id
	private String _id;
	public String emp_name;
	private String emp_email;
	private String emp_mobile;
	private String emp_dob;
	private Address emp_address;
	private String emp_doj;
	private String emp_position;
	private String image_url;
}
