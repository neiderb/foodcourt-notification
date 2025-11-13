package com.foodcourt.notification.domain.exception.auth;

import com.foodcourt.notification.domain.exception.BusinessException;

public class InvalidRoleException extends BusinessException {
	public InvalidRoleException(String message) {
		super(message);
	}
}
