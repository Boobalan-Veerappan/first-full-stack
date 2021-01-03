package com.heraizen.utilReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.heraizen.DTO.EmployeeEntry;


public class CsvReaderUtil {

	private static final String FILE_NAME = "login_out.csv";

	private CsvReaderUtil()
	{
		
	}
	
	public static List<EmployeeEntry> readDataUtilFile() throws IOException, URISyntaxException
	{
		List<EmployeeEntry> employeeEntryList = new ArrayList<>();
		
		List<String> list = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(FILE_NAME).toURI()));
		employeeEntryList = list.stream().skip(1).map(row -> convertRowToStudent(row)).collect(Collectors.toList());
	return employeeEntryList;
	}
	
	private static EmployeeEntry convertRowToStudent(String row) {
		String[] datas= row.split(",");
		int i=0;
		String id = datas[i++];
		String time = datas[i++];
		
		EmployeeEntry emp = EmployeeEntry.builder().id(id).time(time).build();
		
		return emp;
		
		
	}
	
}
