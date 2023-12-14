package com.congnghejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.congnghejava.entity.LopEntity;

public interface LopRepository extends JpaRepository<LopEntity, Long>{
	LopEntity findOneByCode(String code);
}
