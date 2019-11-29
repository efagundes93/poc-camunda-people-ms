package br.com.atox.people.utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

	/**
	 * @return random LocalDate
	 */
	public static LocalDate generateDate() {
		
		  long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
		  long maxDay = LocalDate.of(2019, 12, 31).toEpochDay();
		  long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		  LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		  return randomDate;
	}
	
	public static String generateEmail() {
		
		return RandomStringUtils.random(10, true, true) + "@" +  RandomStringUtils.random(10, true, true) + ".com" ;
	}
	
	public static String generateName() {
		
		return RandomStringUtils.random(50, true, true) ;
	}
	
	public static String generateLegalDocumentNumber() {
		
		return String.valueOf(org.apache.commons.lang3.RandomUtils.nextLong(9999999999L, 99999999999999L));
	}
}
