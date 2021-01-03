package com.heraizen.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntryStart_End {

	String StartTime;
	String EndTime;
	long Mintue;
}
