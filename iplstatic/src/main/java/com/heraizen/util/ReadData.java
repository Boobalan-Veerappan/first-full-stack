package com.heraizen.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.heraizen.ipldomain.Team;
import com.heraizen.iplstatic.AppConfiguration;

@Component
public class ReadData {

	@Autowired
	AppConfiguration app;
	 public List<Team> readdata()
	 {
		 return app.getTeams();
	 }
}
