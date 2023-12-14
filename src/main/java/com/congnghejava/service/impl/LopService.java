package com.congnghejava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.congnghejava.converter.LopConverter;
import com.congnghejava.dto.LopDTO;
import com.congnghejava.entity.GiaoVienEntity;
import com.congnghejava.entity.LopEntity;
import com.congnghejava.repository.GiaoVienRepository;
import com.congnghejava.repository.LopRepository;
import com.congnghejava.service.ILopService;

@Service
public class LopService implements ILopService {
	@Autowired
	private LopRepository lopRepository;
	
	@Autowired
	private GiaoVienRepository giaoVienRepository;
		
	@Autowired
	private LopConverter lopConverter;
	
	@Override
	public List<LopDTO> findAll(Pageable pageable) {
		List<LopDTO> models = new ArrayList<>();
		List<LopEntity> entities = lopRepository.findAll(pageable).getContent();
		for (LopEntity item: entities) {
			LopDTO lopDTO = lopConverter.toDto(item);
			models.add(lopDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) lopRepository.count();
	}

	@Override
	public LopDTO findById(long id) {
		LopEntity entity = lopRepository.findOne(id);
		return lopConverter.toDto(entity);
	}

	@Override
	public LopDTO save(LopDTO dto) {
		GiaoVienEntity giaoVien = giaoVienRepository.findOneByCode(dto.getTeacherCode());
		LopEntity lopEntity = new LopEntity();
		if (dto.getId() != null) {
			LopEntity oldLop = lopRepository.findOne(dto.getId());
			oldLop.setTeacher(giaoVien);
			lopEntity = lopConverter.toEntity(oldLop,dto);
		}else {			
			lopEntity = lopConverter.toEntity(dto);
			lopEntity.setTeacher(giaoVien);
		}
		return lopConverter.toDto(lopRepository.save(lopEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			lopRepository.delete(id);
		}	
		
	}



	
}
