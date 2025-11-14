package com.foodcourt.notification.application.config;

import com.foodcourt.notification.domain.gateways.NotificationGateway;
import com.foodcourt.notification.domain.ports.NotifyCompletedOrderPort;
import com.foodcourt.notification.domain.usecases.NotifyCompletedOrderPortUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationBeanConfig {
	
	@Bean
	public NotifyCompletedOrderPort notifyCompletedOrderPort(
		NotificationGateway notificationGateway
	) {
		return new NotifyCompletedOrderPortUseCase(
			notificationGateway
		);
	}
	
}
