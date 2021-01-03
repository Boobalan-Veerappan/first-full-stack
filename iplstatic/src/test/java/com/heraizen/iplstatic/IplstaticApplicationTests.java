package com.heraizen.iplstatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.heraizen.iplDto.PlayerDTO;
import com.heraizen.iplDto.TeamDTO;
import com.heraizen.iplDto.TeamLabelsDTO;
import com.heraizen.ipldomain.Team;
import com.heraizen.iplservice.IplStatService;
import com.heraizen.iplservice.IplStatServiceImplement;
import com.heraizen.resourceData.ResourceData;
import com.heraizen.util.ReadData;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
//import static org.junit.jupiter*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class IplstaticApplicationTests {

	@Autowired
	private ReadData read;
	
	
	@Qualifier("read1")
	@Autowired
	private IplStatServiceImplement ipl;
	
	
	@Autowired
	TeamLabelsDTO teamlabel;

	@BeforeEach
	public void initMethod() {

	
		ipl.addTeam(read.readdata());
		

		
	}

	@Test
	
	public void match() {
		List<PlayerDTO> player = new ArrayList<>();
	
			   
		PlayerDTO p1= new PlayerDTO();
		p1.setLabel("MI");
		p1.setName("Rohit Sharma (R)");
		p1.setPrice(150000000);
		p1.setRole("Batsman");
		PlayerDTO p2= new PlayerDTO();
		p2.setLabel("MI");
		p2.setName("Anmolpreet Singh (R)");
		p2.setPrice(8000000);
		p2.setRole("Batsman");
		PlayerDTO p3= new PlayerDTO();
		p3.setLabel("MI");
		p3.setName("Ankul Roy (R)");
		p3.setPrice(2000000);
		p3.setRole("Batsman");
		player.add(p1);
		player.add(p2);
		player.add(p3);
		
        assertThat(player,ipl.getPlayersByLabel("mi"));
		
	}
	
	
	
	
	@Test
	public void teamDetails()
	{
		List<TeamDTO> teamdetails = new ArrayList<TeamDTO>();
		TeamDTO t1 = new TeamDTO();
		t1.setCity("Mumbai, Maharashtra");
		t1.setCoach("Mahela Jaywardene");
		t1.setHomeGround("Wankhede Stadium, Mumbai");
		t1.setLabel("MI");
		t1.setName("Mumbai Indians");
		TeamDTO t2 = new TeamDTO();
		t2.setCity("Delhi, NCR");
		t2.setCoach("Ricky Ponting");
		t2.setHomeGround("Feroz Shah Kotla Ground");
		t2.setLabel("DC");
		t2.setName("Delhi Capitals");
		
		teamdetails.add(t1);
		teamdetails.add(t2);
		
		Assertions.assertEquals(teamdetails,equalTo(ipl.getTeamDetails()));
		
	}
	
	

	@AfterEach
	public void deleteMehod() {

	}

}
