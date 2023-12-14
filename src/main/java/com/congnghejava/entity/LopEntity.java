package com.congnghejava.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classUIT")
public class LopEntity extends BaseEntity{

	@Column(name = "classname")
	private String classname;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "total")
	private String total;
	
	@OneToMany(mappedBy = "classUIT")
	private List<HocVienEntity> hocVien = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_code")
    private GiaoVienEntity teacher;

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public GiaoVienEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(GiaoVienEntity teacher) {
		this.teacher = teacher;
	}
	
}
