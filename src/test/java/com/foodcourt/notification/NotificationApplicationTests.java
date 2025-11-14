package com.foodcourt.notification;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.mockito.Mockito.times;

class NotificationApplicationTests {
	
	@Test
	void shouldInvokeSpringApplicationRunWhenMainIsCalled() {
		try (MockedStatic<SpringApplication> springAppMock = Mockito.mockStatic(SpringApplication.class)) {
			springAppMock.when(() -> SpringApplication.run(Mockito.eq(NotificationApplication.class), Mockito.any(String[].class)))
				.thenReturn(Mockito.mock(ConfigurableApplicationContext.class));
			
			NotificationApplication.main(new String[]{});
			
			springAppMock.verify(() -> SpringApplication.run(Mockito.eq(NotificationApplication.class), Mockito.any(String[].class)), times(1));
		}
	}
	
}
