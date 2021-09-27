package com.gwen.englishnumberconverttowords.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gwen.englishnumberconverttowords.model.Money;
import com.gwen.englishnumberconverttowords.service.FormatNumberService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class EnglishNumberConvertToWordsController {

	private static Logger logger = LoggerFactory.getLogger(EnglishNumberConvertToWordsController.class);

	@Autowired
	FormatNumberService formatNumberService;

	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value = "/getAmount", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Money> getAmount(@RequestParam(value = "amount") Long amount,
			@RequestParam(value = "cents", required = false) Long cents) {
		logger.info("CALL SERVICE REST getValue() With Parameters: {} / {}", amount, cents);

		return ResponseEntity.ok(formatNumberService.formatRuleBasedAmount(amount, cents));
	}

}
