package com.congnghejava.converter;

import org.springframework.stereotype.Component;

import com.congnghejava.dto.KhoaDTO;
import com.congnghejava.entity.KhoaEntity;

@Component
public class KhoaConverter {
	public KhoaDTO toDto(KhoaEntity entity) {
		KhoaDTO result = new KhoaDTO();
		result.setId(entity.getId());
		result.setName(entity.getFacultyName());
		result.setCode(entity.getCode());
		return result;
	}
	
	public KhoaEntity toEntity(KhoaDTO dto) {
		KhoaEntity result = new KhoaEntity ();
		result.setFacultyName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
	
	public KhoaEntity toEntity(KhoaEntity result, KhoaDTO dto) {
		result.setFacultyName(dto.getName());
		result.setCode(dto.getCode());
		return result;
	}
}
