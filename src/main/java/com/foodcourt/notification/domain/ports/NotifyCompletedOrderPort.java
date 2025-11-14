package com.foodcourt.notification.domain.ports;

import com.foodcourt.notification.domain.model.notification.SmsContactInfo;

public interface NotifyCompletedOrderPort {
	
	void execute(SmsContactInfo smsContactInfo);
	
}
