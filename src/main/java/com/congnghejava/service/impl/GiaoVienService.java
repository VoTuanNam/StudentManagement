package com.congnghejava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.congnghejava.converter.GiaoVienConverter;
import com.congnghejava.dto.GiaoVienDTO;
import com.congnghejava.entity.GiaoVienEntity;
import com.congnghejava.entity.KhoaEntity;
import com.congnghejava.repository.GiaoVienRepository;
import com.congnghejava.repository.KhoaRepository;
import com.congnghejava.service.IGiaoVienService;

@Service
public class GiaoVienService implements IGiaoVienService {
	@Autowired
	private GiaoVienRepository giaoVienRepository;
	
	@Autowired
	private KhoaRepository khoaRepository;
	
	@Autowired
	private GiaoVienConverter giaoVienConverter;
	
	@Override
	public List<GiaoVienDTO> findAll(Pageable pageable) {
		List<GiaoVienDTO> models = new ArrayList<>();
		List<GiaoVienEntity> entities = giaoVienRepository.findAll(pageable).getContent();
		for (GiaoVienEntity item: entities) {
			GiaoVienDTO giaoVienDTO = giaoVienConverter.toDto(item);
			models.add(giaoVienDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) giaoVienRepository.count();
	}

	@Override
	public GiaoVienDTO findById(long id) {
		GiaoVienEntity entity = giaoVienRepository.findOne(id);
		return giaoVienConverter.toDto(entity);
	}

	@Override
	public GiaoVienDTO save(GiaoVienDTO dto) {
		KhoaEntity khoa = khoaRepository.findOneByCode(dto.getFacultyCode());
		GiaoVienEntity giaoVienEntity = new GiaoVienEntity();
		if (dto.getId() != null) {
			GiaoVienEntity oldGiaoVien = giaoVienRepository.findOne(dto.getId());
			oldGiaoVien.setFaculty(khoa);
			giaoVienEntity = giaoVienConverter.toEntity(oldGiaoVien,dto);
		}else {			
			giaoVienEntity = giaoVienConverter.toEntity(dto);
			giaoVienEntity.setFaculty(khoa);
		}
		return giaoVienConverter.toDto(giaoVienRepository.save(giaoVienEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			giaoVienRepository.delete(id);
		}	
		
	}
}
