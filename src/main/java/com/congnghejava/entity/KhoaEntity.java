package com.congnghejava.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class KhoaEntity extends BaseEntity{

	@Column(name = "facultyName")
	private String facultyName;
	
	@Column(name = "code")
	private String code;

	@OneToMany(mappedBy = "faculty")
	private List<HocVienEntity> hocVien = new ArrayList<>();
	
	@OneToMany(mappedBy = "faculty")
	private List<GiaoVienEntity> giaoVien = new ArrayList<>();

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<HocVienEntity> getHocVien() {
		return hocVien;
	}

	public void setHocVien(List<HocVienEntity> hocVien) {
		this.hocVien = hocVien;
	}

	public List<GiaoVienEntity> getGiaoVien() {
		return giaoVien;
	}

	public void setGiaoVien(List<GiaoVienEntity> giaoVien) {
		this.giaoVien = giaoVien;
	}
	
	
}
