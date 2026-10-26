package com.ruby.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier_part")
public class SupplierPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierPartId;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;

    // 확장 필드 (예: 해당 협력사에서의 부품 단가, 공급 가능 여부 등)
    private Integer unitPrice; 
}
