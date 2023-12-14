package com.congnghejava.converter;

import org.springframework.stereotype.Component;

import com.congnghejava.dto.HocVienDTO;
import com.congnghejava.entity.HocVienEntity;

@Component
public class HocVienConverter {
	public HocVienDTO toDto(HocVienEntity entity) {
		HocVienDTO result = new HocVienDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setCode(entity.getCode());
		result.setDateOfBirth(entity.getDateOfBirth());
		result.setGender(entity.getGender());
		result.setClassUIT(entity.getClassUIT().getClassname());
		result.setFaculty(entity.getFaculty().getFacultyName());
		result.setClassUITCode(entity.getClassUIT().getCode());
		result.setFacultyCode(entity.getFaculty().getCode());
		return result;
	}
	
	public HocVienEntity toEntity(HocVienDTO dto) {
		HocVienEntity result = new HocVienEntity();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		result.setDateOfBirth(dto.getDateOfBirth());
		result.setGender(dto.getGender());
		return result;
	}
	
	public HocVienEntity toEntity(HocVienEntity result, HocVienDTO dto) {
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		result.setDateOfBirth(dto.getDateOfBirth());
		result.setGender(dto.getGender());
		return result;
	}
}
