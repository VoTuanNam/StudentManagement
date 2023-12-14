package com.congnghejava.converter;

import org.springframework.stereotype.Component;

import com.congnghejava.dto.GiaoVienDTO;
import com.congnghejava.entity.GiaoVienEntity;

@Component
public class GiaoVienConverter {
	public GiaoVienDTO toDto(GiaoVienEntity entity) {
		GiaoVienDTO result = new GiaoVienDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setCode(entity.getCode());
		result.setDateOfBirth(entity.getDateOfBirth());
		result.setGender(entity.getGender());
		result.setFaculty(entity.getFaculty().getFacultyName());
		result.setFacultyCode(entity.getFaculty().getCode());
		return result;
	}
	
	public GiaoVienEntity toEntity(GiaoVienDTO dto) {
		GiaoVienEntity result = new GiaoVienEntity ();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		result.setDateOfBirth(dto.getDateOfBirth());
		result.setGender(dto.getGender());
		return result;
	}
	
	public GiaoVienEntity toEntity(GiaoVienEntity result, GiaoVienDTO dto) {
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		result.setDateOfBirth(dto.getDateOfBirth());
		result.setGender(dto.getGender());
		return result;
	}
}
