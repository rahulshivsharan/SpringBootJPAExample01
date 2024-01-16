package com.sm.demo.vo;

import java.io.Serializable;
import java.util.Set;

public class DepartmentVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 174893234256L;

	private long departmentId;
		
	private String departmentName;
		
	private Set<StudentVO> students;
	
	public DepartmentVO() {
		
	}
	
	public DepartmentVO(long departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public DepartmentVO(long departmentId, String departmentName, Set<StudentVO> studentList) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.students = studentList;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public Set<StudentVO> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentVO> students) {
		this.students = students;
	}
	
	@Override
	public int hashCode() {
		Long l = new Long(this.departmentId);
		return l.hashCode() * 27; 
	}
	
	@Override
	public boolean equals(Object o) {
		DepartmentVO d = (DepartmentVO) o;
		return (d.getDepartmentId() == this.departmentId) ? true : false;
	}

	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		strb.append("DepartmentID ").append(this.departmentId).append(",")
			.append("Department Name ").append(this.departmentName).append("\n");
		
		return strb.toString();
	}
}
