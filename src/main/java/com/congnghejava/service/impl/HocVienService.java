package com.congnghejava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.congnghejava.converter.HocVienConverter;
import com.congnghejava.dto.HocVienDTO;
import com.congnghejava.entity.HocVienEntity;
import com.congnghejava.entity.KhoaEntity;
import com.congnghejava.entity.LopEntity;
import com.congnghejava.repository.HocVienRepository;
import com.congnghejava.repository.KhoaRepository;
import com.congnghejava.repository.LopRepository;
import com.congnghejava.service.IHocVienService;

@Service
public class HocVienService implements IHocVienService {
	
	@Autowired
	private HocVienRepository hocVienRepository;
	
	@Autowired
	private LopRepository lopRepository;
	
	@Autowired
	private KhoaRepository khoaRepository;
	
	@Autowired
	private HocVienConverter hocVienConverter;
	@Override
	public List<HocVienDTO> findAll(Pageable pageable) {
		List<HocVienDTO> models = new ArrayList<>();
		List<HocVienEntity> entities = hocVienRepository.findAll(pageable).getContent();
		for (HocVienEntity item: entities) {
			HocVienDTO hocVienDTO = hocVienConverter.toDto(item);
			models.add(hocVienDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) hocVienRepository.count();
	}

	@Override
	public HocVienDTO findById(long id) {
		HocVienEntity entity = hocVienRepository.findOne(id);
		return hocVienConverter.toDto(entity);
	}

	@Override
	@Transactional
	public HocVienDTO save(HocVienDTO dto) {
		LopEntity lop = lopRepository.findOneByCode(dto.getClassUITCode());
		KhoaEntity khoa = khoaRepository.findOneByCode(dto.getFacultyCode());
		HocVienEntity hocVienEntity = new HocVienEntity();
		if (dto.getId() != null) {
			HocVienEntity oldHocVien = hocVienRepository.findOne(dto.getId());
			oldHocVien.setClassUIT(lop);
			oldHocVien.setFaculty(khoa);
			hocVienEntity = hocVienConverter.toEntity(oldHocVien,dto);
		}else {			
			hocVienEntity = hocVienConverter.toEntity(dto);
			hocVienEntity.setClassUIT(lop);
			hocVienEntity.setFaculty(khoa);
		}
		return hocVienConverter.toDto(hocVienRepository.save(hocVienEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			hocVienRepository.delete(id);
		}	
	}

}
