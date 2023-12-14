package com.congnghejava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.congnghejava.dto.HocVienDTO;

public interface IHocVienService {
	List<HocVienDTO> findAll(Pageable pageable);
	int getTotalItem();
	HocVienDTO findById(long id);
	HocVienDTO save(HocVienDTO dto);
	void delete(long[] ids);

}
