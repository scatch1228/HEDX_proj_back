package com.ruby.service;

import com.ruby.persistence.DeliveryRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

@Service
public class DeliveryService {

    private final DeliveryRepo deliveryRepo;

    public DeliveryService(DeliveryRepo deliveryRepo) {
    	this.deliveryRepo = deliveryRepo;
    }
    
    public Map<String, Object> getOtdRate(Integer supplierId, LocalDate startDate, LocalDate endDate) {
        List<Object[]> result = deliveryRepo.getOtdRateBySupplier(supplierId, startDate, endDate);
        
        Map<String, Object> response = new HashMap<>();
        if (!result.isEmpty()) {
            Object[] row = result.get(0);
            long total = (Long) row[1];
            long onTimeComplete = (Long) row[2];
            double otdRate = total > 0 ? ((double) onTimeComplete / total) * 100.0 : 0.0;

            response.put("supplierId", row[0]);
            response.put("totalDeliveries", total);
            response.put("onTimeCompleteCount", onTimeComplete);
            response.put("otdRatePercent", otdRate);
        } else {
            response.put("supplierId", supplierId);
            response.put("totalDeliveries", 0);
            response.put("onTimeCompleteCount", 0);
            response.put("otdRatePercent", 0.0);
        }
        
        return response;
    }
}