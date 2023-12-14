package com.congnghejava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.congnghejava.dto.KhoaDTO;
import com.congnghejava.service.IKhoaService;

@RestController(value = "khoaAPIOfAdmin")
public class KhoaAPI {
	
	@Autowired
	private IKhoaService khoaService;
	
	@PostMapping("/api/khoa")
	public KhoaDTO createKhoa(@RequestBody KhoaDTO khoaDTO) {
		return khoaService.save(khoaDTO);
	}
	
	@PutMapping("/api/khoa")
	public KhoaDTO updateKhoa(@RequestBody KhoaDTO updateKhoa) {
		return khoaService.save(updateKhoa);
	}
	
	@DeleteMapping("/api/khoa")
	public void deleteKhoa(@RequestBody long[] ids) {
		khoaService.delete(ids);
	}
}