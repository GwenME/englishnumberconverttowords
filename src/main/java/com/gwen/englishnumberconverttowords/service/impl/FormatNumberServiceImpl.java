package com.gwen.englishnumberconverttowords.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gwen.englishnumberconverttowords.model.Money;
import com.gwen.englishnumberconverttowords.service.FormatNumberService;
import com.gwen.englishnumberconverttowords.util.EnglishNumberConvertToWords;

@Service
public class FormatNumberServiceImpl implements FormatNumberService {

	private static Logger logger = LoggerFactory.getLogger(FormatNumberServiceImpl.class);

	public Money formatRuleBasedAmount(Long amount, Long cents) {

		logger.info("FormatNumberServiceImpl for {} {}", amount, cents);

		Money money = new Money();
		money.setAmount(EnglishNumberConvertToWords.convert(amount));
		if (cents != null) {
			money.setCents(EnglishNumberConvertToWords.convert(cents));
		}
		return money;

	}
}
