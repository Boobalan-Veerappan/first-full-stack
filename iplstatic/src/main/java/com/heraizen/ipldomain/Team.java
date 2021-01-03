package com.heraizen.ipldomain;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
@Component
@Scope("prototype")
public class Team {
private String _id;
		private String name;
		private String coach;
		private String city;
		private String home;
		private String label;
	private List<Player> players;
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCoach() {
			return coach;
		}
		public void setCoach(String coach) {
			this.coach = coach;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		@Override
		public String toString() {
			return "Team [name=" + name + ", coach=" + coach + ", city=" + city + ", home=" + home + ", label=" + label
					+ ", players=" + players + "]";
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public List<Player> getPlayers() {
			return players;
		}
		public void setPlayers(List<Player> players) {
			this.players = players;
		}
		public String getHome() {
			return home;
		}
		public void setHome(String home) {
			this.home = home;
		}

	}


