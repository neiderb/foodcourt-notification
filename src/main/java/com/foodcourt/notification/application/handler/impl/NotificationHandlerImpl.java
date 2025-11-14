package com.foodcourt.notification.application.handler.impl;

import com.foodcourt.notification.application.dto.request.NotifyCompletedOrderRequest;
import com.foodcourt.notification.application.handler.NotificationHandler;
import com.foodcourt.notification.application.mappers.NotifyCompletedOrderMapper;
import com.foodcourt.notification.domain.ports.NotifyCompletedOrderPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationHandlerImpl implements NotificationHandler {
	
	private final NotifyCompletedOrderPort notifyCompletedOrderPort;
	
	@Override
	public void notifyCompletedOrder(NotifyCompletedOrderRequest notifyCompletedOrderRequest) {
		log.trace("Handling notification for completed order: {}", notifyCompletedOrderRequest);
		notifyCompletedOrderPort.execute(
			NotifyCompletedOrderMapper.INSTANCE.toDomain(notifyCompletedOrderRequest)
		);
	}
	
}
