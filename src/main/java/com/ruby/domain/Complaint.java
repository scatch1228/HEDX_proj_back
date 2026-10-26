package com.ruby.domain;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Complaint {
	@Id
	@Schema(description = "민원 시퀀스")
	private Integer complaintId;
	
	@ManyToOne
	@JoinColumn(name="part_id", nullable=false)
	@Schema(description = "민원 부품")
	private Part partId;
	
	@ManyToOne
	@JoinColumn(name="delivery_id", nullable=false)
	@Schema(description = "민원 납기")
	private Delivery deliveryId;
	
	@Schema(description = "민원 날짜")
	private LocalDate complaintDate;
	
	@Schema(description = "불량 타입")
	private String defectType;
	
	@Schema(description = "민원 내용")
	private String complaintMessage;
	
}
