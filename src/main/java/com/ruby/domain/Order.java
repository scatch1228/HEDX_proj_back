package com.ruby.domain;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name="orders")
@Builder
public class Order {
	@Id
	@Schema(description = "발주 시퀀스")
	private Integer orderId;

	@ManyToOne
	@JoinColumn(name="supplier_id", nullable=false)
	@Schema(description = "발주 협력사")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="part_id", nullable=false)
	@Schema(description = "발주 부품")
	private Part part;
	
	@Schema(description = "발주 수량")
	private Integer quantity;
	
	@Schema(description = "부품 비용")
	private Integer cost;

	@Schema(description = "발주 날짜")
	private LocalDate orderDate;
	
	@Schema(description = "납기 예상일")
	private LocalDate expectedDate;
}
