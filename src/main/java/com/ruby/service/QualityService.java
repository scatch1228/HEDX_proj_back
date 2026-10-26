package com.ruby.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ruby.persistence.ComplaintRepo;

@Service
public class QualityService {
	
	private final ComplaintRepo complaintRepo;

	public QualityService(ComplaintRepo complaintRepo) {
        this.complaintRepo = complaintRepo;
    }
		
    public List<Object[]> getQualityTrend(Integer supplierId, Integer partId, LocalDate startDate, LocalDate endDate) {
        // 날짜 형식 예: startDate = "2026-01-01", endDate = "2026-12-31"
        return complaintRepo.getQualityTrendStats(supplierId, partId, startDate, endDate);
    }
}
