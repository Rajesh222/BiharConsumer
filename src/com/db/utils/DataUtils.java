package com.db.utils;

import java.util.HashMap;
import java.util.Map;

public class DataUtils {

	private DataUtils() {
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

	public static Map<String, String> applicableBerthTypes() {
		Map<String, String> birthTypes = new HashMap<>();
		birthTypes.put("LB", "LB");
		birthTypes.put("RB", "RB");
		birthTypes.put("ULB", "ULB");
		birthTypes.put("URB", "URB");
		return birthTypes;
	}
	
	public static Map<String, String> applicableQuotaList(){
		Map<String, String> quotaTypes = new HashMap<>();
		quotaTypes.put("BERTH/SR. CITIZEN", "BERTH/SR. CITIZEN");
		quotaTypes.put("LEDIES", "LEDIES");
		return quotaTypes;
	}
}
