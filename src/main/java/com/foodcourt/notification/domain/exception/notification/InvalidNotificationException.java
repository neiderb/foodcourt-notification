package com.foodcourt.notification.domain.exception.notification;

import com.foodcourt.notification.domain.exception.BusinessException;

public class InvalidNotificationException extends BusinessException {
	public InvalidNotificationException(String message) {
		super(message);
	}
}
