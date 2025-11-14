package com.foodcourt.notification.application.handler;

import com.foodcourt.notification.application.dto.request.NotifyCompletedOrderRequest;

public interface NotificationHandler {
	
	void notifyCompletedOrder(NotifyCompletedOrderRequest notifyCompletedOrderRequest);
	
}
