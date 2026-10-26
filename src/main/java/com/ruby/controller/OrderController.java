package com.ruby.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.service.OrderService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	//private final OrderService orderService;
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllOrder() {
		//return ResponseEntity.ok(orderService.getOrderList());
		return ResponseEntity.ok(null);
	}
}
