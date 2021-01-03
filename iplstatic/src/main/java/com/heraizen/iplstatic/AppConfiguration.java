package com.heraizen.iplstatic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heraizen.ipldomain.*;
import com.heraizen.util.ReadData;


@Configuration
@ConfigurationProperties(prefix = "app")

public class AppConfiguration {

	private List<Team> teams = new ArrayList<>();

	private String message;

	
	public List<com.heraizen.ipldomain.Team> getTeams() {
		return teams;
	}

	


	public String getMessage() {
		
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}




	@Bean
	public Working getwork()
	{
		return new Working();
	}
	
	
	
}
