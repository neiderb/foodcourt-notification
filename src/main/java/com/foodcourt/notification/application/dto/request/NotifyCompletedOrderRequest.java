package com.foodcourt.notification.application.dto.request;

public record NotifyCompletedOrderRequest(
	String phoneNumber,
	String securePin
) {}
