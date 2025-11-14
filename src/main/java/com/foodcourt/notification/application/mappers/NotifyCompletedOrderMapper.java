package com.foodcourt.notification.application.mappers;

import com.foodcourt.notification.application.dto.request.NotifyCompletedOrderRequest;
import com.foodcourt.notification.domain.model.notification.SmsContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotifyCompletedOrderMapper {
	
	NotifyCompletedOrderMapper INSTANCE = Mappers.getMapper(NotifyCompletedOrderMapper.class);
	
	SmsContactInfo toDomain(NotifyCompletedOrderRequest request);
	
}
