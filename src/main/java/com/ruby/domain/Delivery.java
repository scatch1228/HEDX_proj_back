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
public class Delivery {
	@Id
	@Schema(description = "납기 시퀀스")
	private Integer deliveryId;

	@ManyToOne
	@JoinColumn(name="order_id", nullable=false)
	@Schema(description = "납기 발주")
	private Order order;
	
	@Schema(description = "납기 날짜")
	private LocalDate deliveryDate;
	
	@Schema(description = "납기 수량")
	private Integer deliveryQuantity;
	
	@Schema(description = "납기 상태")
	private String deliveryStatus;
}
