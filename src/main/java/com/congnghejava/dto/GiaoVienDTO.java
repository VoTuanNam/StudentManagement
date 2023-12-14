package com.congnghejava.dto;

public class GiaoVienDTO extends AbstractDTO<GiaoVienDTO> {
	
	private String name;
	private String code;
	private String dateOfBirth;
	private String gender;
	private String faculty;
	private String facultyCode;
	
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
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getFacultyCode() {
		return facultyCode;
	}
	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}
	
	
	
}
