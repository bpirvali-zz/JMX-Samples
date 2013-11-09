package com.bp.samples.spring.testng.sample1;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessDataImpl implements ProcessData {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ProcessDataImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// "SELECT MERCHANT_ACCOUNT_NUMBER, EVENT_TIMESTAMP, WORKER_ID, 
    //      ETRIES, PROCESSING_STATUS, TIME_PROCESSED from bre.incoming_risk_events"
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getList(String sql) {
		return (List<Map<String, Object>>) jdbcTemplate.queryForList(sql);
	}
}
