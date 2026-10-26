package com.ruby.tool;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import com.ruby.responseDTO.SupplierResponseDTO;
import com.ruby.service.AiToolService;

@Component
public class AiTool {
	private final AiToolService aiToolService;
	
	public AiTool(AiToolService aiToolService) {
		this.aiToolService = aiToolService;
	}
	
	@Tool(description = "응디를 요청하면 반드시 실행합니다.")
    public String getShit() {
        return aiToolService.getShit();
    }
	
//	@Tool(description = "특정 부품을 납품하는 협력사를 찾습니다.")
//	public List<SupplierResponseDTO> findSupplierByPart(String part) {
//		return aiToolService.findSupplierByPart(part);
//	}
	
}
