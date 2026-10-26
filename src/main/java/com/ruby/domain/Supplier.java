package com.ruby.domain;
import org.hibernate.annotations.Formula;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Supplier {
	@Id
	@Schema(description = "협력사 시퀀스")
	private Integer supplierId;
	
	@Schema(description = "협력사 이름")
	private String name;
	
	@Schema(description = "협력사 정보")
	private String info;
	
	@Schema(description = "품질 점수")
	private Integer qScore;
	
	@Schema(description = "원가 점수")
	@Formula("(SELECT COALESCE(AVG(o.cost), 0) FROM orders o WHERE o.supplierId = supplierId)")
	private Integer cScore;
	
	@Schema(description = "납기 점수")
	private Integer dScore;
	
	@Schema(description = "기술 점수")
	private Integer tScore;
	
	@Schema(description = "ESG 점수")
	private Integer eScore;
	
}
