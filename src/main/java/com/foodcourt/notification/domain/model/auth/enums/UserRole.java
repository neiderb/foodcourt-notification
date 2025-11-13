package com.foodcourt.notification.domain.model.auth.enums;

import com.foodcourt.notification.domain.exception.auth.InvalidRoleException;

import static com.foodcourt.notification.domain.constants.AuthErrorMessage.INVALID_ROLE;

public enum UserRole {
	
	ADMIN,
	OWNER,
	EMPLOYEE,
	CLIENT;
	
	public static UserRole getRoleof(String role) {
		for (UserRole userRole : UserRole.values()) {
			if (userRole.name().equalsIgnoreCase(role)) {
				return userRole;
			}
		}
		throw new InvalidRoleException(INVALID_ROLE);
	}
	
}
