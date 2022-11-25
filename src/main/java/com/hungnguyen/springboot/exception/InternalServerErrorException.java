package com.hungnguyen.springboot.exception;

public class InternalServerErrorException extends RuntimeException {
	public InternalServerErrorException(String message) {
		super(message);
	}
}
