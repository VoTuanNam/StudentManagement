package com.congnghejava.converter;

import org.springframework.stereotype.Component;

import com.congnghejava.dto.LopDTO;
import com.congnghejava.entity.LopEntity;

@Component
public class LopConverter {
	public LopDTO toDto(LopEntity entity) {
		LopDTO result = new LopDTO();
		result.setId(entity.getId());
		result.setName(entity.getClassname());
		result.setCode(entity.getCode());
		result.setTotal(entity.getTotal());
		result.setTeacherName(entity.getTeacher().getName());
		result.setTeacherCode(entity.getTeacher().getCode());
		return result;
	}
	
	public LopEntity toEntity(LopDTO dto) {
		LopEntity result = new LopEntity ();
		result.setClassname(dto.getName());
		result.setCode(dto.getCode());
		result.setTotal(dto.getTotal());
		return result;
	}
	
	public LopEntity toEntity(LopEntity result, LopDTO dto) {
		result.setClassname(dto.getName());
		result.setCode(dto.getCode());
		result.setTotal(dto.getTotal());
		return result;
	}
}
