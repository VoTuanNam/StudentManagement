package com.congnghejava.dto;

public class HocVienDTO extends AbstractDTO<HocVienDTO> {
	
	private String name;
	private String code;
	private String dateOfBirth;
	private String gender;
	private String classUIT;
	private String faculty;
	private String classUITCode;
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
	public String getClassUIT() {
		return classUIT;
	}
	public void setClassUIT(String classUIT) {
		this.classUIT = classUIT;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getClassUITCode() {
		return classUITCode;
	}
	public void setClassUITCode(String classUITCode) {
		this.classUITCode = classUITCode;
	}
	public String getFacultyCode() {
		return facultyCode;
	}
	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}
	
	
}
