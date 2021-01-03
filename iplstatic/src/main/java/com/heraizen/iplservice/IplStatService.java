package com.heraizen.iplservice;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.heraizen.iplDto.*;
import com.heraizen.ipldomain.Roles;
import com.heraizen.ipldomain.Team;
@Component
public interface IplStatService {
		public TeamLabelsDTO getTeamLables();
		public List<PlayerDTO> getPlayersByLabel(String label);
		public List<PlayerCountDTO> getRolesCountByLabel(String label);
		public List<PlayerDTO> getPlayersByLabelAndRoles(String label,Roles role);
		public List<RolesAmountDTO> getAmountSpentbyTeam(String label);
		public List<RolesAmountDTO> getAmountSpentOnRoleByLabel(String label);
		public Map<Roles,List<PlayerDTO>> getMaximumPaidPlayerForEachRoles();
		public List<PlayerDTO> getAllPlayer();
		public List<TeamDTO> getTeamDetails();
		public void addTeam(List<Team> teams);
		public void removeallTeam();
		
}
