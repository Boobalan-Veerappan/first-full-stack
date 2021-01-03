package com.heraizen.iplservice;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.heraizen.iplDto.PlayerCountDTO;
import com.heraizen.iplDto.PlayerDTO;
import com.heraizen.iplDto.RolesAmountDTO;
import com.heraizen.iplDto.TeamDTO;
import com.heraizen.iplDto.TeamLabelsDTO;
import com.heraizen.ipldomain.Player;
import com.heraizen.ipldomain.Roles;
import com.heraizen.ipldomain.Team;
@Component
@Scope("prototype")

public class IplStatServiceImplement implements IplStatService {

	List<Team>TeamList = new ArrayList<>();
	
	@Autowired
	Team t;
	
	
	
	@Autowired
	TeamLabelsDTO label;
	
	@Override
	public TeamLabelsDTO getTeamLables() {
		
		
		TeamList.forEach(e->{
		label.getLabels().add(e.getLabel());
			
		});
		System.out.println("$#333333333333333335"+label.getLabels());
		return label;
	}

	@Override
	public List<PlayerDTO> getPlayersByLabel(String label) {
		
		
		
		TeamList.forEach(e->{
//			System.out.println(e.getCity()+"##");
				
			});
		




List<PlayerDTO> player = new ArrayList<PlayerDTO>();
if (TeamList.stream().anyMatch(e -> e.getLabel().equalsIgnoreCase(label))) {
	TeamList.stream().forEach(e -> {

		if (e.getLabel().equalsIgnoreCase(label)) {
			t = e;
		}
	});

	t.getPlayers().stream().forEach(e -> {

		

		PlayerDTO p = new PlayerDTO();
		p.setLabel(e.getLabel());
p.setName(e.getName());
p.setPrice(e.getPrice());
p.setRole(e.getRole());
		player.add(p);

		
		
		
	});
	
player.forEach(e->{
	
	System.out.println(e.getName());
	
});


	
	
} else {
	System.out.println("Please Enter Valid Labels");
}

return player;
		
	}

	@Override
	public List<PlayerCountDTO> getRolesCountByLabel(String label) {

		return null;
	}

	@Override
	public List<PlayerDTO> getPlayersByLabelAndRoles(String label, Roles role) {

		return null;
	}

	@Override
	public List<RolesAmountDTO> getAmountSpentbyTeam(String label) {

		return null;
	}

	@Override
	public List<RolesAmountDTO> getAmountSpentOnRoleByLabel(String label) {

		return null;
	}

	@Override
	public Map<Roles, List<PlayerDTO>> getMaximumPaidPlayerForEachRoles() {

		return null;
	}

	@Override
	public List<PlayerDTO> getAllPlayer() {

		return null;
	}

	@Override
	public List<TeamDTO> getTeamDetails() {
		List<TeamDTO> teamdetails = new ArrayList<TeamDTO>();

		TeamList.stream().forEach(e -> {
			TeamDTO detail = new TeamDTO();
			detail.setCity(e.getCity());
			detail.setCoach(e.getCoach());
			detail.setHomeGround(e.getHome());
			detail.setLabel(e.getLabel());
			detail.setName(e.getName());
			teamdetails.add(detail);
		});

		return teamdetails;
		
	}

	@Override
	public void addTeam(List<Team> teams) {
		
		this.TeamList = teams;
		System.out.println("########");
		
		System.out.println(TeamList);
		
	}

	@Override
	public void removeallTeam() {
	
		
	}
	



}
