package com.congnghejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.congnghejava.entity.KhoaEntity;

public interface KhoaRepository extends JpaRepository<KhoaEntity, Long>{
	KhoaEntity findOneByCode(String code);
}
