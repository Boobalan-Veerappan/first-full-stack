package com.heraizen.iplstatic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class IplstaticApplication implements CommandLineRunner {
	@Autowired
	private AppConfiguration appconfig;
	public static void main(String[] args) {
		SpringApplication.run(IplstaticApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	
		appconfig.getTeams().forEach(e->{
			System.out.println(e.getLabel()+"  " + e.getHome());
			System.out.println("< ------------------  "+e.getLabel()+"  ------------------->111");
			e.getPlayers().forEach(e1->{
				
				System.out.println(e1.getName());
				
			});
		});
	}

}
