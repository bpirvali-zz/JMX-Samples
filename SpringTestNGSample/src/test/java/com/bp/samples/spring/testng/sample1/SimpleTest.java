package com.bp.samples.spring.testng.sample1;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@ContextConfiguration("file:src/test/resources/ApplicationContext-Test.xml")
public class SimpleTest extends AbstractTestNGSpringContextTests {
	@Resource private ApplicationContext appCtx;
	
	@BeforeClass
	public void runLocalCluster() {
		ProcessData pd = (ProcessData)appCtx.getBean("processData");
		List<Map<String, Object>> l = pd.getList("SELECT merchant_account_number, event_timestamp FROM bre.incoming_risk_events");
		Assert.assertEquals(l.size(), 1);
		Main.printList(l, "TABLE incoming_risk_events");
	}
	
    @Test
    public void testSample() {
        
    	//Assert.assertTrue(true);
    }
}
