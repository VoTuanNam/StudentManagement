package com.congnghejava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.congnghejava.dto.KhoaDTO;

public interface IKhoaService {
	List<KhoaDTO> findAll(Pageable pageable);
	int getTotalItem();
	KhoaDTO findById(long id);
	KhoaDTO save(KhoaDTO dto);
	void delete(long[] ids);
}
