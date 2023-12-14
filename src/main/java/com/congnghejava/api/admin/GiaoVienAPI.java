package com.congnghejava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.congnghejava.dto.GiaoVienDTO;
import com.congnghejava.service.IGiaoVienService;

@RestController(value = "giaoVienAPIOfAdmin")
public class GiaoVienAPI {
	
	@Autowired
	private IGiaoVienService giaoVienService;
	
	@PostMapping("/api/giaovien")
	public GiaoVienDTO createGiaoVien(@RequestBody GiaoVienDTO giaoVienDTO) {
		return giaoVienService.save(giaoVienDTO);
	}
	
	@PutMapping("/api/giaovien")
	public GiaoVienDTO updateGiaoVien(@RequestBody GiaoVienDTO updateGiaoVien) {
		return giaoVienService.save(updateGiaoVien);
	}
	
	@DeleteMapping("/api/giaovien")
	public void deleteGiaoVien(@RequestBody long[] ids) {
		giaoVienService.delete(ids);
	}
}