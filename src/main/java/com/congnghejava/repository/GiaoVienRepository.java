package com.congnghejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.congnghejava.entity.GiaoVienEntity;

public interface GiaoVienRepository extends JpaRepository<GiaoVienEntity, Long> {
	GiaoVienEntity findOneByCode(String code);
}

