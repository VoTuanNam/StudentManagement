package com.congnghejava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.congnghejava.dto.LopDTO;

public interface ILopService {
	List<LopDTO> findAll(Pageable pageable);
	int getTotalItem();
	LopDTO findById(long id);
	LopDTO save(LopDTO dto);
	void delete(long[] ids);
}
