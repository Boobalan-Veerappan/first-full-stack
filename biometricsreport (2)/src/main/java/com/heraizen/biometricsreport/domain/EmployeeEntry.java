package com.heraizen.biometricsreport.domain;


import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeEntry {

	private String userid;
	private Date datetime;
}
