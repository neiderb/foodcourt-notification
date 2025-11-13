package com.foodcourt.notification.domain.exception.auth;

import com.foodcourt.notification.domain.exception.BusinessException;

public class InvalidUserException extends BusinessException {
	public InvalidUserException(String message) {
		super(message);
	}
}
