package com.hiberus.headbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Headbook not found")
public class HeadBookException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -384596350086620430L;


	public HeadBookException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeadBookException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HeadBookException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HeadBookException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
