package com.sm.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentTbl")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private long studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name = "dept_id", nullable = true)
	private Department dept;
	
	public Student() {}
	
	public Student(long studentId, String studentName, Department department) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.dept = department;
	}
	
	public Student(long studentId, String studentName) {
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

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	@Override
	public boolean equals(Object o) {
		Student s = (Student) o;
		return (s.getStudentId() == this.studentId) ? true : false; 
	}
	
	@Override
	public int hashCode() {
		Long l = new Long(this.studentId);
		int num =  l.hashCode() * 117;
		return num;
	}
}
