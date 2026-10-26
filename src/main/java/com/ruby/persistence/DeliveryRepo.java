package com.ruby.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ruby.domain.Delivery;

public interface DeliveryRepo extends JpaRepository<Delivery, Integer>{

	@Query("SELECT o.supplier.supplierId AS supplierId, " +
	           "COUNT(d) AS totalDeliveries, " +
	           "SUM(CASE WHEN d.deliveryDate <= o.expectedDate AND d.deliveryQuantity >= o.quantity THEN 1 ELSE 0 END) AS onTimeCompleteCount " +
	           "FROM Delivery d " +
	           "JOIN d.order o " +
	           "WHERE o.supplier.supplierId = :supplierId " +
	           "AND d.deliveryDate BETWEEN :startDate AND :endDate " +
	           "GROUP BY o.supplier.supplierId")
	    List<Object[]> getOtdRateBySupplier(@Param("supplierId") Integer supplierId,
	                                        @Param("startDate") LocalDate startDate,
	                                        @Param("endDate") LocalDate endDate);
}
