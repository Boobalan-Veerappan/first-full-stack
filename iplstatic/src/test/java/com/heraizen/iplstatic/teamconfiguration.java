package com.heraizen.iplstatic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import com.heraizen.iplDto.TeamLabelsDTO;
import com.heraizen.ipldomain.Team;
import com.heraizen.iplservice.IplStatServiceImplement;
import com.heraizen.util.ReadData;

@Configuration
////@ComponentScan(basePackages = {"src.main.java.com.heraizen.iplservice"})
//@ContextConfiguration(locations = "src/main/java/com/heraizen/iplstatic")
public class teamconfiguration {

	@Bean
	public ReadData read()
	{
		return new ReadData();
	}
	
	@Bean
	public IplStatServiceImplement read1()
	{
		return new IplStatServiceImplement();
	}
	
	@Bean
	public TeamLabelsDTO team1()
	{
		return new TeamLabelsDTO();
	}
	
	@Bean
	public Team tea()
	{
		return new Team();
	}
}
