package com.foodcourt.notification.domain.gateways;

import com.foodcourt.notification.domain.model.notification.SmsContactInfo;

public interface NotificationGateway {
	
	void sendNotify(SmsContactInfo smsContactInfo);
	
}
