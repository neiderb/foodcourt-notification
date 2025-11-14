package com.foodcourt.notification.infrastructure.rest;

import com.foodcourt.notification.application.dto.request.NotifyCompletedOrderRequest;
import com.foodcourt.notification.application.handler.NotificationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.foodcourt.notification.infrastructure.rest.constants.paths.NotificationPath.BASE;
import static com.foodcourt.notification.infrastructure.rest.docapi.NotificationDocApi.*;

@Slf4j
@Tag(name = TAG_NOTIFICATION)
@RestController
@RequiredArgsConstructor
@RequestMapping(BASE)
public class NotificationController {
	
	private final NotificationHandler notificationHandler;
	
	@Operation(summary = NOTIFY_COMPLETED_ORDER_SUMMARY)
	@ApiResponse(
		responseCode = "204",
		description = NOTIFY_COMPLETED_ORDER_DESCRIPTION
	)
	@PostMapping
	ResponseEntity<Void> notifyOrder(@RequestBody @Valid NotifyCompletedOrderRequest notifyCompletedOrderRequest) {
		log.trace("notifyOrder: {}", notifyCompletedOrderRequest);
		notificationHandler.notifyCompletedOrder(notifyCompletedOrderRequest);
		return ResponseEntity.noContent().build();
	}
	
}
