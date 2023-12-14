package com.congnghejava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class GiaoVienEntity extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "dateofbirth")
	private String dateOfBirth;

	@Column(name = "gender")
	private String gender;

	@OneToOne(mappedBy = "teacher")
	private LopEntity lop;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private KhoaEntity faculty;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LopEntity getLop() {
		return lop;
	}

	public void setLop(LopEntity lop) {
		this.lop = lop;
	}

	public KhoaEntity getFaculty() {
		return faculty;
	}

	public void setFaculty(KhoaEntity faculty) {
		this.faculty = faculty;
	}

	
}
