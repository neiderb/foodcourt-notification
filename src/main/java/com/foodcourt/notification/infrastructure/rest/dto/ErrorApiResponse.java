package com.foodcourt.notification.infrastructure.rest.dto;

public record ErrorApiResponse(
	int code,
	String message
) {}
