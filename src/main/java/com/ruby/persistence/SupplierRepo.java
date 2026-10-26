package com.ruby.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.domain.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
	//List<Supplier> findByPartNameContaining(String part);
}
