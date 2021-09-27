package com.gwen.englishnumberconverttowords.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gwen.englishnumberconverttowords.model.Money;
import com.gwen.englishnumberconverttowords.service.impl.FormatNumberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormatNumberServiceTest {
	
	private static Logger logger = LoggerFactory.getLogger(FormatNumberServiceTest.class);

	@Autowired
	private FormatNumberServiceImpl formatNumberServiceImpl;
	
	@Test
	public void formatRuleBasedAmountTest() {
		
		Long amount = (long) 150;
		Long cents = (long) 50;
		
		Money actual = formatNumberServiceImpl.formatRuleBasedAmount(amount, cents);
		Money expected = new Money("one hundred fifty","fifty");
		
		logger.info("Expected : {}", expected.toString());
		logger.info("Actual : {}", actual.toString());
		
		assertEquals(expected.toString(), actual.toString());
		
	}
}
