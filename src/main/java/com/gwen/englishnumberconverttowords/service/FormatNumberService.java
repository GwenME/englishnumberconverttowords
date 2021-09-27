/**
 * 
 */
package com.gwen.englishnumberconverttowords.service;

import com.gwen.englishnumberconverttowords.model.Money;

public interface FormatNumberService {

	public Money formatRuleBasedAmount(Long amount, Long cents);
}
