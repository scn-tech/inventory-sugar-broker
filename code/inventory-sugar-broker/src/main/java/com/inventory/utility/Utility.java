package com.inventory.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

public class Utility {
	public static java.sql.Date getCurrentDateTime() {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		System.out.println(date);
		return date;
	}

	public static String getCurrentDateTimeForDbFileName() {
		Date backupDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return format.format(backupDate);
	}

	public static String getCurrentDateTimeInFormat(String outputFormat) {
		Date backupDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat(outputFormat);
		return format.format(backupDate);
	}

	/*
	 * public static String getLoggedUsername() { Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); return
	 * auth.getName(); }
	 * 
	 * public static String getLoggedUserHasRole(String role) { Authentication auth
	 * = SecurityContextHolder.getContext().getAuthentication(); return
	 * (auth.getAuthorities().toString().contains(role))?"true":"false"; }
	 */

	public static Pageable pageRequestSortId() {
		return PageRequest.of(0, 50, Direction.DESC, "id");
	}

	public static Pageable pageRequestCustomSortDesc(String column) {
		return PageRequest.of(0, 50, Direction.DESC, column);
	}

	public static Pageable pageRequestCustomSort(String columnAndSort, Integer pageSize) {
		String[] info = columnAndSort.split("##");
		Integer size = (pageSize != null && pageSize > 0) ? pageSize : 50;

		if ("DESC".equalsIgnoreCase(info[1]))
			return PageRequest.of(0, size, Direction.DESC, info[0]);
		else
			return PageRequest.of(0, size, Direction.ASC, info[0]);
	}
	
	/*
	 * public static void setCurrentDateIfNull(SummaryReport bill) {
	 * if(bill.getFromDate()==null || bill.getFromDate().isBlank() ||
	 * bill.getFromDate().isEmpty())
	 * bill.setFromDate(Utility.getCurrentDateTimeInFormat("yyyy-MM-dd"));
	 * if(bill.getToDate()==null || bill.getToDate().isBlank() ||
	 * bill.getToDate().isEmpty())
	 * bill.setToDate(Utility.getCurrentDateTimeInFormat("yyyy-MM-dd")); }
	 */
}
