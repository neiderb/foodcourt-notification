package com.foodcourt.notification.domain.model.notification;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsContactInfo {
	
	private String phoneNumber;
	private String securePin;
	
}
