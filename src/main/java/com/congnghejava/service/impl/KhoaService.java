package com.congnghejava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.congnghejava.converter.KhoaConverter;
import com.congnghejava.dto.KhoaDTO;
import com.congnghejava.entity.KhoaEntity;
import com.congnghejava.repository.KhoaRepository;
import com.congnghejava.service.IKhoaService;

@Service
public class KhoaService implements IKhoaService {
	@Autowired
	private KhoaRepository khoaRepository;
		
	@Autowired
	private KhoaConverter khoaConverter;
	
	@Override
	public List<KhoaDTO> findAll(Pageable pageable) {
		List<KhoaDTO> models = new ArrayList<>();
		List<KhoaEntity> entities = khoaRepository.findAll(pageable).getContent();
		for (KhoaEntity item: entities) {
			KhoaDTO giaoVienDTO = khoaConverter.toDto(item);
			models.add(giaoVienDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) khoaRepository.count();
	}

	@Override
	public KhoaDTO findById(long id) {
		KhoaEntity entity = khoaRepository.findOne(id);
		return khoaConverter.toDto(entity);
	}

	@Override
	public KhoaDTO save(KhoaDTO dto) {
		KhoaEntity khoaEntity = new KhoaEntity();
		if (dto.getId() != null) {
			KhoaEntity oldKhoa = khoaRepository.findOne(dto.getId());
			khoaEntity = khoaConverter.toEntity(oldKhoa,dto);
		}else {			
			khoaEntity = khoaConverter.toEntity(dto);
		}
		return khoaConverter.toDto(khoaRepository.save(khoaEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			khoaRepository.delete(id);
		}	
	}

	
}
