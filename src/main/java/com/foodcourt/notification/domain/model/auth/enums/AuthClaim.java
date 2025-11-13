package com.foodcourt.notification.domain.model.auth.enums;

public enum AuthClaim {
	USER_ID("userId"),
	ROLE("role"),
	RESTAURANT_ID("restaurantId");
	
	public final String value;
	
	AuthClaim(String value) {
		this.value = value;
	}
}
