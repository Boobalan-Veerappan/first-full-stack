package com.heraizen.iplDto;

import com.heraizen.ipldomain.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerCountDTO {

	
	String role;
	String label;
	int count;
}
