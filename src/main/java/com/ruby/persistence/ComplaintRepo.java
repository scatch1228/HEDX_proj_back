package com.ruby.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ruby.domain.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Integer> {

	@Query(value = "SELECT SUBSTRING(CAST(c.complaint_date AS VARCHAR), 1, 7) AS \"month\", c.defect_type, COUNT(*) AS defectCount " +
            "FROM complaint c " +
            "JOIN delivery d ON c.delivery_id = d.delivery_id " +
            "JOIN orders o ON d.order_id = o.order_id " +
            "WHERE o.supplier_id = :supplierId " +
            "AND c.part_id = :partId " +
            "AND c.complaint_date BETWEEN :startDate AND :endDate " +
            "GROUP BY SUBSTRING(CAST(c.complaint_date AS VARCHAR), 1, 7), c.defect_type " +
            "ORDER BY \"month\" ASC", 
            nativeQuery = true)
	    List<Object[]> getQualityTrendStats(@Param("supplierId") Integer supplierId,
	                                        @Param("partId") Integer partId,
	                                        @Param("startDate") LocalDate startDate,
	                                        @Param("endDate") LocalDate endDate);
}
