package com.congnghejava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.congnghejava.dto.HocVienDTO;
import com.congnghejava.service.IHocVienService;

@RestController(value = "hocVienAPIOfAdmin")
public class HocVienAPI {
	
	@Autowired
	private IHocVienService hocVienService;
	
	@PostMapping("/api/hocvien")
	public HocVienDTO createHocVien(@RequestBody HocVienDTO hocVienDTO) {
		return hocVienService.save(hocVienDTO);
	}
	
	@PutMapping("/api/hocvien")
	public HocVienDTO updateHocVien(@RequestBody HocVienDTO updateHocVien) {
		return hocVienService.save(updateHocVien);
	}
	
	@DeleteMapping("/api/hocvien")
	public void deleteHocVien(@RequestBody long[] ids) {
		hocVienService.delete(ids);
	}
}