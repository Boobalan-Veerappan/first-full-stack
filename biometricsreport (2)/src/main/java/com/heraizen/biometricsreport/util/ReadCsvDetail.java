package com.heraizen.biometricsreport.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.heraizen.biometricsreport.domain.EmployeeEntry;


@Component
public class ReadCsvDetail {

	private static final String FILE_NAME = "ESSL_DUMP.csv";
	
	public List<EmployeeEntry> loadCsvReader() {
		
		List<EmployeeEntry> employeeEntryList = new ArrayList<>();
		try {
			List<String> list = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(FILE_NAME).toURI()));
			employeeEntryList = list.stream().skip(1).map(row -> convertRowToEntries(row)).collect(Collectors.toList());
		} catch (IOException | URISyntaxException e) {
			System.out.println("While reading csv file: " + e);
		}
		return employeeEntryList;
	}
	
	private  EmployeeEntry convertRowToEntries(String row) {
		
		String[] data = row.split(",");
		
		int i = 3;
		String userid = data[i++] ;
		Date datetime = getFormattedDate(data[i++]);
		
		
		EmployeeEntry entries = EmployeeEntry.builder().datetime(datetime).userid(userid).build();

		return entries;
	}

	private Date getFormattedDate(String datetime) {
		SimpleDateFormat localDate = new SimpleDateFormat("mm/dd/yyyy HH:mm:ss");
		Date date = null;
		try {
			date = localDate.parse(datetime);
		    return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
