package com.sm.demo.vo;

import java.io.Serializable;

public class StudentVO implements Serializable{
	
	private long studentId;
	
	private String studentName;
	
	private DepartmentVO dept;
	
	public StudentVO() {}
	
	public StudentVO(long studentId, String studentName, DepartmentVO department) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.dept = department;
	}
	
	public StudentVO(long studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;		
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public DepartmentVO getDept() {
		return dept;
	}

	public void setDept(DepartmentVO dept) {
		this.dept = dept;
	}
	
	@Override
	public boolean equals(Object o) {
		StudentVO s = (StudentVO) o;
		return (s.getStudentId() == this.studentId) ? true : false; 
	}
	
	@Override
	public int hashCode() {
		Long l = new Long(this.studentId);
		int num =  l.hashCode() * 17;
		return num;
	}
}
