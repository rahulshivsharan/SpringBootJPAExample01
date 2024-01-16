package com.sm.demo.service;

import java.util.List;

import com.sm.demo.vo.DepartmentVO;
import com.sm.demo.vo.StudentVO;

public interface CollegeService {
	public List<DepartmentVO> fetchAllDepartments() throws Exception;
	public DepartmentVO saveDepartment(DepartmentVO department) throws Exception;
	public List<StudentVO> fetchAllStudents() throws Exception;
	public StudentVO saveStudent(StudentVO student) throws Exception;
}
