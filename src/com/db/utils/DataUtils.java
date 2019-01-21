package com.db.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class DataUtils {

	private DataUtils() {
	}

	public static String getBaseURl(HttpServletRequest request) {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String contextPath = request.getContextPath();
		StringBuilder url = new StringBuilder();
		url.append(scheme).append("://").append(serverName);
		if ((serverPort != 80) && (serverPort != 443)) {
			url.append(":").append(serverPort);
		}
		url.append(contextPath);
		if (url.toString().endsWith("/")) {
			url.append("/");
		}
		return url.toString();
	}

	public static Map<String, String> validIdCardTypes() {
		Map<String, String> idTypes = new HashMap<>();
		idTypes.put("NULL_IDCARD", "NULL_IDCARD");
		idTypes.put("DRIVING_LICENSE", "DRIVING_LICENSE");
		idTypes.put("PASSPORT", "PASSPORT");
		idTypes.put("PANCARD", "PANCARD");
		idTypes.put("GOVT_ICARD", "GOVT_ICARD");
		idTypes.put("BANK_PASSBOOK", "BANK_PASSBOOK");
		idTypes.put("STUDENT_ICARD", "STUDENT_ICARD");
		idTypes.put("CREDIT_CARD", "CREDIT_CARD");
		idTypes.put("UNIQUE_ICARD", "UNIQUE_ICARD");
		idTypes.put("VOTER_ICARD", "VOTER_ICARD");
		return idTypes;
	}

	public static List<String> getBusType() {
		List<String> busTypes = new ArrayList<>();
		busTypes.add("AC");
		busTypes.add("Non AC");
		busTypes.add("Seater");
		busTypes.add("Sleeper");
		return busTypes;
	}

	public static Date convertTimeStampToDate(Timestamp timestamp) {
		Date date=new Date(timestamp.getTime());
		return date;
	}
	
	public Date convertLocalDateToDateFormat(LocalDate localDate) {
		DateFormat dateFormatLD = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormatLD.format(localDate);
		try {
			DateFormat dateFormatDL = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormatDL.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
	}

	public LocalDate convertDateToLocalDateFormat(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString = dateFormat.format(date);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		return LocalDate.parse(dateString, dateTimeFormatter);
	}

	public static Date convertStringToDateFormat(String date, String format) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String convertDateToStringFormat(String date, String format) {
		Date dateValues = convertStringToDateFormat(date, format);
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(dateValues);
	}
	
	public static void main(String[] args) {
		System.out.println(convertDateToStringFormat("12-01-2019", "dd-mm-yyyy"));
	}

	public static String getGenerateOTP() {
		Random rnd = new Random();
		int otp = rnd.nextInt(900000) + 100000;
		return String.valueOf(otp);
	}
}
