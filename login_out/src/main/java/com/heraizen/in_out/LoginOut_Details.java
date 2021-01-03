package com.heraizen.in_out;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.heraizen.DTO.EmployeeEntry;
import com.heraizen.DTO.EntryStart_End;
import com.heraizen.utilReader.CsvReaderUtil;

public class LoginOut_Details {

	List<EmployeeEntry> employeeEntryList = new ArrayList<EmployeeEntry>();

	Map<String, Integer> compare = new HashMap<>();
	Map<String, EntryStart_End> compare1 = new HashMap<>();
	SimpleDateFormat edf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	EntryStart_End max = null;

	public LoginOut_Details() throws IOException, URISyntaxException {

		employeeEntryList = CsvReaderUtil.readDataUtilFile();
		System.out.println("coming"+employeeEntryList);
	}

	public void loginAday() {

		employeeEntryList.forEach(e -> {

			compare.putIfAbsent(e.getId(), 0);

			compare.computeIfPresent(e.getId(), (k, v) -> v + 1);
		});
		employeeEntryList.forEach(e -> {
			System.out.println(" _id : " + e.getId() + " Login Times : " + e.getTime());

		});

	}

	public void startandEndTime() {
		employeeEntryList.forEach(e -> {

			if (compare1.containsKey(e.getId())) {

				compare1.computeIfPresent(e.getId(), (k, v) -> {

					v.setEndTime(e.getTime());

					return v;
				});

			}

			if (!compare1.containsKey(e.getId())) {
				EntryStart_End entry = new EntryStart_End();
				entry.setStartTime(e.getTime());
				compare1.putIfAbsent(e.getId(), entry);
			}

		});

		compare1.entrySet().stream().forEach(e -> {

			System.out.println("Id = " + e.getKey() + " StartTime  = " + e.getValue().getEndTime() + " EndTime = "
					+ e.getValue().getStartTime() + " Mintue = " + e.getValue().getMintue());

		});
	}

	public void hardWorker() {
		long maxmint = 0;
		for (Map.Entry<String, EntryStart_End> compa : compare1.entrySet()) {
			if (compa.getValue().getMintue() > maxmint) {
				maxmint = compa.getValue().getMintue();
				max = compa.getValue();
			}

		}

		System.out.println(max);
	}

}
