package com.ruby.controller;

import com.ruby.dto.QualityTrendRequestDTO;
import com.ruby.service.QualityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quality")
@RequiredArgsConstructor // 수동 생성자로 변경하셨다면 해당 생성자를 사용하셔도 됩니다.
public class QualityController {

    private final QualityService qualityService;

    @PostMapping("/trend")
    public ResponseEntity<List<Object[]>> getQualityTrend(@RequestBody QualityTrendRequestDTO request) {
        // 서비스 호출 (LocalDate 타입 매개변수 전달)
        List<Object[]> trendData = qualityService.getQualityTrend(
                request.getSupplierId(),
                request.getPartId(),
                request.getStartDate(),
                request.getEndDate()
        );

        return ResponseEntity.ok(trendData);
    }
}
