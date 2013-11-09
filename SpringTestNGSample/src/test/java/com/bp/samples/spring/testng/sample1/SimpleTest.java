package com.bp.samples.spring.testng.sample1;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@ContextConfiguration("file:src/main/resources/spring-config.xml")
public class SimpleTest extends AbstractTestNGSpringContextTests {

//    @Test
//    public void testSample() {
//        Assert.assertTrue(true);
//    }
}
