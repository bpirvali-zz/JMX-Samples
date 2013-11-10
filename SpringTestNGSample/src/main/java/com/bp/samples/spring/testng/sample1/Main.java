package com.bp.samples.spring.testng.sample1;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(new String[] { "ApplicationContext.xml" });
		ProcessData pd = (ProcessData)appCtx.getBean("processData");
		
		List<Map<String, Object>> l = pd.getList("SELECT merchant_account_number, event_timestamp FROM bre.incoming_risk_events");
		printList(l, "TABLE incoming_risk_events");
		
		l = pd.getList("SELECT * FROM bre.risk_2_conf");
		printList(l, "TABLE risk_2_conf");
		
		logger.info("Huuuuraaaa!");
	}
	
	public static void printList(List<Map<String, Object>> l, String title) {
		StringBuilder sb = new StringBuilder();
		logger.info("----------------------------------------------");
		logger.info("-- {}", title);
		logger.info("----------------------------------------------");
		for (Map<String, Object> e: l) {
			sb.setLength(0);
			sb.append("(");
			for (Map.Entry<String, Object> en: e.entrySet()) {
				sb.append(en.getKey());
				sb.append("=");
				sb.append(en.getValue());
				sb.append(", ");
				
				//logger.info("key:{}, val:{}", en.getKey(), en.getValue() );
			}
			sb.setLength(sb.length()-2);
			sb.append(")");
			logger.info(sb.toString());
		}
	}
}
