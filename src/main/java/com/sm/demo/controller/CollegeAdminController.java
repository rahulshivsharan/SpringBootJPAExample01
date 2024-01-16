package com.sm.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.demo.entity.Department;
import com.sm.demo.entity.Student;
import com.sm.demo.respository.DepartmentRepository;
import com.sm.demo.service.CollegeService;
import com.sm.demo.vo.DepartmentVO;
import com.sm.demo.vo.StudentVO;

@RestController
@RequestMapping("/api/college")
public class CollegeAdminController {
	
	@Autowired
	@Qualifier("collegeServiceBean")
	private CollegeService collegeService;
	
	@GetMapping("/department")
	public ResponseEntity<List<DepartmentVO>> getAllDepartments() {
		List<DepartmentVO> departmentVOList = null;
		try {
			departmentVOList = collegeService.fetchAllDepartments();
			return new ResponseEntity<>(departmentVOList, HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/department")
	public ResponseEntity<DepartmentVO> createDepartment(@RequestBody DepartmentVO department) {		
		try {
			department = collegeService.saveDepartment(department);
			return new ResponseEntity<DepartmentVO>(department, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/student")
	public ResponseEntity<StudentVO> createStudent(@RequestBody StudentVO student) {
		StudentVO student_ = null;
		try {
			student_ = collegeService.saveStudent(student);
			return new ResponseEntity<StudentVO>(student_, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<StudentVO>> getAllStudent() {
		List<StudentVO> studentList = null;
		try {
			studentList = collegeService.fetchAllStudents();
			return new ResponseEntity<List<StudentVO>>(studentList, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
