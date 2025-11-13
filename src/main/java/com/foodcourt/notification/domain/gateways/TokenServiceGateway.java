package com.foodcourt.notification.domain.gateways;

import com.foodcourt.notification.domain.model.auth.UserClaims;

public interface TokenServiceGateway {
	
	UserClaims parseToken(String token);
	
}
