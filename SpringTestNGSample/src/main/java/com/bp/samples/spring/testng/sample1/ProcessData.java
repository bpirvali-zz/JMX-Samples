package com.bp.samples.spring.testng.sample1;

import java.util.List;
import java.util.Map;

public interface ProcessData {

	// "SELECT MERCHANT_ACCOUNT_NUMBER, EVENT_TIMESTAMP, WORKER_ID, 
	//      ETRIES, PROCESSING_STATUS, TIME_PROCESSED from bre.incoming_risk_events"
	public abstract List<Map<String, Object>> getList(String sql);

}