package com.ruby.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.domain.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
