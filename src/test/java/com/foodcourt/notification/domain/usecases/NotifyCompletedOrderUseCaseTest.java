package com.foodcourt.notification.domain.usecases;

import com.foodcourt.notification.domain.exception.notification.InvalidNotificationException;
import com.foodcourt.notification.domain.gateways.NotificationGateway;
import com.foodcourt.notification.domain.model.notification.SmsContactInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotifyCompletedOrderUseCaseTest {
	
	@InjectMocks
	private NotifyCompletedOrderPortUseCase notifyCompletedOrderPortUseCase;
	
	@Mock
	private NotificationGateway notificationGateway;
	
	@Test
	void shouldNotifySuccessfully() {
		SmsContactInfo smsContactInfo = SmsContactInfo.builder()
			.phoneNumber("+1234567890")
			.securePin("1234")
			.build();
		
		notifyCompletedOrderPortUseCase.execute(smsContactInfo);
		
		verify(notificationGateway).sendNotify(smsContactInfo);
	}
	
	@Test
	void shouldThrowExceptionForInvalidPhoneNumber() {
		SmsContactInfo smsContactInfo = SmsContactInfo.builder()
			.phoneNumber("")
			.securePin("1234")
			.build();
		
		assertThrows(InvalidNotificationException.class, () ->
			notifyCompletedOrderPortUseCase.execute(smsContactInfo));
		
		smsContactInfo.setPhoneNumber(null);
		assertThrows(InvalidNotificationException.class, () ->
			notifyCompletedOrderPortUseCase.execute(smsContactInfo));
	}
	
	@Test
	void shouldThrowExceptionForInvalidSecurePin() {
		SmsContactInfo smsContactInfo = SmsContactInfo.builder()
			.phoneNumber("+1234567890")
			.securePin("")
			.build();
		
		assertThrows(InvalidNotificationException.class, () ->
			notifyCompletedOrderPortUseCase.execute(smsContactInfo));
		
		smsContactInfo.setSecurePin(null);
		assertThrows(InvalidNotificationException.class, () ->
			notifyCompletedOrderPortUseCase.execute(smsContactInfo));
	}
	
}
