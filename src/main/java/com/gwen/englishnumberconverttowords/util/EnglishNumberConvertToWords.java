package com.gwen.englishnumberconverttowords.util;

import java.text.DecimalFormat;

public class EnglishNumberConvertToWords {

	private static final String THOUSAND = " thousand ";

	private static final String ONE_THOUSAND = "one thousand ";

	private static final String MILLION = " million ";

	private static final String BILLION = " billion ";

	private static final String MASK = "000000000000";

	private static final String ZERO = "zero";

	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	/**
	 * 
	 */
	public EnglishNumberConvertToWords() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static String convertLessThanOneThousand(int number) {
		String soFar;

		if (number % 100 < 20) {
			soFar = numNames[number % 100];
			number /= 100;
		} else {
			soFar = numNames[number % 10];
			number /= 10;

			soFar = tensNames[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0) {
			return soFar;
		}
		return numNames[number] + " hundred" + soFar;
	}

	/**
	 * Convert a number a string litteral in english
	 *
	 * @param number the nomber to convert
	 * @return the string litteral of the number
	 */
	public static String convert(long number) {
		// 0 to 999 999 999 999
		if (number == 0) {
			return ZERO;
		}

		String snumber = Long.toString(number);

		// pad with "0"
		String mask = MASK;
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);

		// XXXnnnnnnnnn
		int billions = Integer.parseInt(snumber.substring(0, 3));
		// nnnXXXnnnnnn
		int millions = Integer.parseInt(snumber.substring(3, 6));
		// nnnnnnXXXnnn
		int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
		// nnnnnnnnnXXX
		int thousands = Integer.parseInt(snumber.substring(9, 12));

		String tradBillions;
		switch (billions) {
		case 0:
			tradBillions = "";
			break;
		case 1:
			tradBillions = convertLessThanOneThousand(billions) + BILLION;
			break;
		default:
			tradBillions = convertLessThanOneThousand(billions) + BILLION;
		}
		String result = tradBillions;

		String tradMillions;
		switch (millions) {
		case 0:
			tradMillions = "";
			break;
		case 1:
			tradMillions = convertLessThanOneThousand(millions) + MILLION;
			break;
		default:
			tradMillions = convertLessThanOneThousand(millions) + MILLION;
		}
		result = result + tradMillions;

		String tradHundredThousands;
		switch (hundredThousands) {
		case 0:
			tradHundredThousands = "";
			break;
		case 1:
			tradHundredThousands = ONE_THOUSAND;
			break;
		default:
			tradHundredThousands = convertLessThanOneThousand(hundredThousands) + THOUSAND;
		}
		result = result + tradHundredThousands;

		String tradThousand;
		tradThousand = convertLessThanOneThousand(thousands);
		result = result + tradThousand;

		// remove extra spaces!
		return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	}
}
