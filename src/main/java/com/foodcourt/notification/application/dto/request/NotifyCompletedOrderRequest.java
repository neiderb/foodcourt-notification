package com.foodcourt.notification.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static com.foodcourt.notification.domain.constants.NotificationValidationMessage.PHONE_NUMBER_IS_REQUIRED;
import static com.foodcourt.notification.domain.constants.NotificationValidationMessage.SECURE_PIN_IS_REQUIRED;

public record NotifyCompletedOrderRequest(
	@NotNull(message = PHONE_NUMBER_IS_REQUIRED)
	@NotBlank(message = PHONE_NUMBER_IS_REQUIRED)
	String phoneNumber,
	@NotNull(message = SECURE_PIN_IS_REQUIRED)
	@NotBlank(message = SECURE_PIN_IS_REQUIRED)
	String securePin
) {}
