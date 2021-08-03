package com.creditcard.pymt.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreditcardProcessorException extends RuntimeException {

	private String errMsg;
	private String errCode;

	public CreditcardProcessorException() {
		super();
	}

	public CreditcardProcessorException(String errMsg, String errCode) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
}
