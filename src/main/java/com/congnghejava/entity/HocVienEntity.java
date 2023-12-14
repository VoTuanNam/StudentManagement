package com.congnghejava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class HocVienEntity extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "dateofbirth")
	private String dateOfBirth;

	@Column(name = "gender")
	private String gender;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classUIT_id")
    private LopEntity classUIT;
	
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


	public LopEntity getClassUIT() {
		return classUIT;
	}

	public void setClassUIT(LopEntity classUIT) {
		this.classUIT = classUIT;
	}

	public KhoaEntity getFaculty() {
		return faculty;
	}

	public void setFaculty(KhoaEntity faculty) {
		this.faculty = faculty;
	}

	
}
