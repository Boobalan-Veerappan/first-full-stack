package com.heraizen.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

	public String UserName;
	public String Password;
	public String getUserName() {
		return UserName;
	}
	
	
	public void setUserName(String userName) {
		
		UserName = userName;
	}
public void setPassword(String password) {
		
	Password = password;
	}

public String getPassword()
{
	return Password;
}
	
}
