package com.heraizen.biometricsreport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.heraizen.biometricsreport.domain.EmployeeEntry;
import com.heraizen.biometricsreport.dto.EmployeeEntryInOutDto;
import com.heraizen.biometricsreport.util.ReadCsvDetail;

@SpringBootApplication
public class BiometricsreportApplication implements CommandLineRunner {

	private List<EmployeeEntry> details = new ArrayList<>();

	@Autowired
	private ReadCsvDetail readDetails;

	public static void main(String[] args) {
		SpringApplication.run(BiometricsreportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		details = readDetails.loadCsvReader();

		Map<String, EmployeeEntryInOutDto> detailMap = new HashMap<>();

		List<String> roles = details.stream().map(EmployeeEntry::getUserid).distinct().collect(Collectors.toList());

		roles.forEach(id -> {
			detailMap.put(id, getSortedEmployeeEntries(id));
		});

		detailMap.forEach((k, v) -> {
			System.out.println("\n" + k + "------>" + v.getEntryInTime() + " ------->" + v.getEntryOutTime() + "\n");
		});
		createExcelSheetReportEntry(detailMap);

	}

	private EmployeeEntryInOutDto getSortedEmployeeEntries(String id) {

		List<EmployeeEntry> tempDetails = details.stream().filter(s -> s.getUserid().equals(id))
				.sorted((e, r) -> e.getDatetime().compareTo(r.getDatetime())).collect(Collectors.toList());

		EmployeeEntryInOutDto det = EmployeeEntryInOutDto.builder().entryInTime(tempDetails.get(0).getDatetime())
				.entryOutTime(tempDetails.get(tempDetails.size() - 1).getDatetime()).userid(id).build();
		return det;
	}

	private void createExcelSheetReportEntry(Map<String, EmployeeEntryInOutDto> mappedEntry) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");

		XSSFRow row;

		Set<String> keyid = mappedEntry.keySet();
		int rowid = 0;
		Cell cell;
		row = spreadsheet.createRow(rowid++);
		cell = row.createCell(0);
		cell.setCellValue("Employee Id");
		cell = row.createCell(1);
		cell.setCellValue("Entry Date and Time");
		cell = row.createCell(2);
		cell.setCellValue("Exit Date and Time");
		for (String key : keyid) {
			String outTime = "NA";
			row = spreadsheet.createRow(rowid++);
			EmployeeEntryInOutDto entryObject = mappedEntry.get(key);
			int cellid = 0;
			cell = row.createCell(cellid++);
			cell.setCellValue(entryObject.getUserid());
			cell = row.createCell(cellid++);
			System.out.println(entryObject.getEntryInTime().toInstant().plusSeconds(1500) + " " + entryObject.getEntryInTime().toInstant());
			if(entryObject.getEntryOutTime().toInstant().isAfter(entryObject.getEntryInTime().toInstant().plusSeconds(1500))) {
				outTime = entryObject.getEntryOutTime().toInstant().toString();
			}
			cell.setCellValue(entryObject.getEntryInTime().toInstant().toString());
			cell = row.createCell(cellid++);
			
			cell.setCellValue(outTime);
			
		}
		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File("/home/spaneos/Downloads/EmployeeEntry.xlsx"));

		workbook.write(out);
		out.close();
		workbook.close();
		System.out.println("Writesheet.xlsx written successfully");

	}

}
