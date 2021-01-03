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
@AllArgsConstructor
@NoArgsConstructor
public class RolesAmountDTO {

	String role;
	double amount;
}
