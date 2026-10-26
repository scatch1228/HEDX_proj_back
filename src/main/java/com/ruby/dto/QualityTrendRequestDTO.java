package com.ruby.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QualityTrendRequestDTO {
	private Integer supplierId;
    private Integer partId;
    private LocalDate startDate;
    private LocalDate endDate;
}
