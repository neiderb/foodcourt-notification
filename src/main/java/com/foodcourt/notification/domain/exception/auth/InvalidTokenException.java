package com.foodcourt.notification.domain.exception.auth;

import com.foodcourt.notification.domain.exception.BusinessException;

public class InvalidTokenException extends BusinessException {
	public InvalidTokenException(String message) {
		super(message);
	}
}
