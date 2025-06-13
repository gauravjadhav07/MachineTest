package com.Gaurav.ExceptionGaurav;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrductNotFoundException extends RuntimeException {

	public PrductNotFoundException(String msg) {
		super(msg);
		log.debug("PrductNotFoundException occures :: ");

	}
}
