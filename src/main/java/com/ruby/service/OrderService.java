package com.ruby.service;

import java.util.List;

import com.ruby.domain.Order;

public interface OrderService {
	List<Order> getOrderList();
	List<Order> findByOrderId(Integer orderId);
}
