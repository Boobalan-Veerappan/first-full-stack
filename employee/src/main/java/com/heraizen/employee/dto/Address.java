package com.heraizen.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String local;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	
}
