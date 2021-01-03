package com.heraizen.biometricsreport.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeEntryInOutDto {

	private String userid;
	private Date entryInTime;
	private Date entryOutTime;
}
