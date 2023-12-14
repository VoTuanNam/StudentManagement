package com.congnghejava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.congnghejava.dto.GiaoVienDTO;

public interface IGiaoVienService {
	List<GiaoVienDTO> findAll(Pageable pageable);
	int getTotalItem();
	GiaoVienDTO findById(long id);
	GiaoVienDTO save(GiaoVienDTO dto);
	void delete(long[] ids);
}
