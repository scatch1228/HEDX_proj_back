package com.ruby.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ruby.domain.Supplier;
import com.ruby.persistence.SupplierRepo;
import com.ruby.responseDTO.SupplierResponseDTO;

@Service
public class AiToolService {
	
	private final SupplierRepo supplierRepo;
	
	public AiToolService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }
	
	public String getShit() {
		System.out.println("응디 메서드가 실행되었다네");
		return "{\"status\": \"success\", \"data\": \"응디!\"}";
	}
	
//	public List<SupplierResponseDTO> findSupplierByPart(String part) {
//        // 1. Query your database using Spring Data JPA
//        List<Supplier> entities = supplierRepo.findByPartNameContaining(part);
//
//        // 2. Map the database entities to your DTOs
//        List<SupplierResponseDTO> list = new ArrayList<SupplierResponseDTO>();
//        for(Supplier e:entities) {
//        	list.add(
//        	new SupplierResponseDTO(part, 
//        			e.getSupplierId(), 
//        			e.getName(), 
//        			e.getInfo(), 
//        			e.getQScore(), 
//        			e.getCScore(), 
//        			e.getDScore(), 
//        			e.getTScore(), 
//        			e.getEScore())
//        	);
//        }
//        return list;
//    }
}
