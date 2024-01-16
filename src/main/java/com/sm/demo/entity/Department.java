package com.sm.demo.entity;


import java.util.List;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DepartmentTbl")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private long departmentId;
	
	@Column(name = "dept_name")	
	private String departmentName;
	
	@OneToMany(mappedBy = "dept",fetch = FetchType.LAZY)	
	private Set<Student> students;
	
	public Department() {
		
	}
	
	public Department(long departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public Department(long departmentId, String departmentName, Set<Student> studentList) {
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
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@Override
	public int hashCode() {
		Long l = new Long(this.departmentId);
		return l.hashCode() * 127; 
	}
	
	@Override
	public boolean equals(Object o) {
		Department d = (Department) o;
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
