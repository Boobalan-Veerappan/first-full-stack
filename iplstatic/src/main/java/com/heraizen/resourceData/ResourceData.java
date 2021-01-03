package com.heraizen.resourceData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.heraizen.ipldomain.Team;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
@Getter
@Setter
@Builder
@Repository
@Scope("prototype")
public class ResourceData {
//	@Autowired
//	Team t1 ;
//	@Autowired
//	Team t2;
//	public List<Team> allTeam()
//	{
//		t1.setCity("chennai");
//		t2.setCity("delhi");
//		
//		List<Team> teams = new ArrayList();
//		
//		teams.add(t1);
//		teams.add(t2);
//		
//		return teams;
//	}
	
}
