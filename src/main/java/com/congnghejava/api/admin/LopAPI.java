package com.congnghejava.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.congnghejava.dto.LopDTO;
import com.congnghejava.service.ILopService;

@RestController(value = "lopAPIOfAdmin")
public class LopAPI {
	
	@Autowired
	private ILopService lopService;
	
	@PostMapping("/api/lop")
	public LopDTO createLop(@RequestBody LopDTO lopDTO) {
		return lopService.save(lopDTO);
	}
	
	@PutMapping("/api/lop")
	public LopDTO updateLop(@RequestBody LopDTO updateLop) {
		return lopService.save(updateLop);
	}
	
	@DeleteMapping("/api/lop")
	public void deleteLop(@RequestBody long[] ids) {
		lopService.delete(ids);
	}
}