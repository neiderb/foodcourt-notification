package com.foodcourt.notification.domain.usecases;

import com.foodcourt.notification.domain.exception.notification.InvalidNotificationException;
import com.foodcourt.notification.domain.gateways.NotificationGateway;
import com.foodcourt.notification.domain.model.notification.SmsContactInfo;
import com.foodcourt.notification.domain.ports.NotifyCompletedOrderPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import static com.foodcourt.notification.domain.constants.NotificationValidationMessage.INVALID_PHONE_NUMBER;
import static com.foodcourt.notification.domain.constants.NotificationValidationMessage.INVALID_SECURE_PIN;

@Slf4j
@RequiredArgsConstructor
public class NotifyCompletedOrderPortUseCase implements NotifyCompletedOrderPort {
	
	private final NotificationGateway notificationGateway;
	
	@Override
	public void execute(SmsContactInfo smsContactInfo) {
		validatePhoneNumber(smsContactInfo.getPhoneNumber());
		validateSecurePin(smsContactInfo.getSecurePin());
		notificationGateway.sendNotify(smsContactInfo);
	}
	
	private void validatePhoneNumber(String phoneNumber) {
		log.trace("Validating phone number: {}", phoneNumber);
		if (!StringUtils.hasText(phoneNumber)) throw new InvalidNotificationException(INVALID_PHONE_NUMBER);
	}
	
	private void validateSecurePin(String securePin) {
		log.trace("Validating secure PIN: {}", securePin);
		if (!StringUtils.hasText(securePin)) throw new InvalidNotificationException(INVALID_SECURE_PIN);
	}
	
}
