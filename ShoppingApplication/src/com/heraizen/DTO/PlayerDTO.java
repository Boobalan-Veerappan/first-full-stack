package com.heraizen.DTO;


import lombok.AllArgsConstructor;
//import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

	String role;
	String name;
	double price; 
	String label;
	public String getname() {
		// TODO Auto-generated method stub
		return name;
	}
}
