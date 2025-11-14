package com.foodcourt.notification.infrastructure.adapters.sns;

import com.foodcourt.notification.domain.gateways.NotificationGateway;
import com.foodcourt.notification.domain.model.notification.SmsContactInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class SmsSender implements NotificationGateway {
	
	private final SnsClient snsClient;
	
	@Override
	public void sendNotify(SmsContactInfo smsContactInfo) {
		log.trace("Notifying order completion to phone number: {}", smsContactInfo.getPhoneNumber());
		String message = buildMessage(smsContactInfo.getSecurePin());
		PublishRequest request = PublishRequest.builder()
			.message(message)
			.phoneNumber(smsContactInfo.getPhoneNumber())
			.build();
		
		snsClient.publish(request);
		log.debug("SMS notification sent to {}", smsContactInfo.getPhoneNumber());
	}
	
	private String buildMessage(String securePin) {
		return String.format("Your order is ready! Use the following PIN to collect your order: %s", securePin);
	}
	
}
