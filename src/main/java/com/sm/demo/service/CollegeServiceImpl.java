package com.sm.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.demo.entity.Department;
import com.sm.demo.entity.Student;
import com.sm.demo.respository.DepartmentRepository;
import com.sm.demo.respository.StudentRepository;
import com.sm.demo.vo.DepartmentVO;
import com.sm.demo.vo.StudentVO;

@Service("collegeServiceBean")
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	private DepartmentRepository departmentRespository;
	
	@Autowired
	private StudentRepository studentRespository; 
	
	@Override
	public List<DepartmentVO> fetchAllDepartments() throws Exception {
		List<Department> departmentList = departmentRespository.findAll();
		List<DepartmentVO> deptList = new ArrayList<DepartmentVO>();
		departmentList.stream().forEach(dept -> {
			DepartmentVO vo = new DepartmentVO(dept.getDepartmentId(), dept.getDepartmentName());
			Set<StudentVO> studentList = new HashSet<StudentVO>();
			Set<Student> students = dept.getStudents();
			
			students.stream().forEach(student -> {
				studentList.add(new StudentVO(student.getStudentId(), student.getStudentName()));				
			});			
			vo.setStudents(studentList);
			
			deptList.add(vo);
		});
		return deptList;
	}

	@Override
	public DepartmentVO saveDepartment(DepartmentVO departmentVO) throws Exception {
		Department deptEntity = new Department(departmentVO.getDepartmentId(), departmentVO.getDepartmentName());
		final Set<StudentVO> studentVOList1 = (departmentVO.getStudents() != null) ? departmentVO.getStudents() : new HashSet<StudentVO>();		
		final Set<Student> studentEntityList1 = new HashSet<Student>();
		
		studentVOList1.stream().forEach(s -> {
			studentEntityList1.add(new Student(s.getStudentId(), s.getStudentName()));
		});
		deptEntity.setStudents(studentEntityList1);		
		
		deptEntity = departmentRespository.save(deptEntity);
		final Set<StudentVO> studentVOList2 = new HashSet<StudentVO>();
		
		DepartmentVO vo = new DepartmentVO(deptEntity.getDepartmentId(), deptEntity.getDepartmentName());		
				
		
		final Set<Student> studentEntityList2 =	deptEntity.getStudents();
		studentEntityList2.stream().forEach(studentEnity ->{
			studentVOList2.add(new StudentVO(studentEnity.getStudentId(), studentEnity.getStudentName()));
		});
		
		vo.setStudents(studentVOList2);
		return vo;
	}
	
	@Override
	public List<StudentVO> fetchAllStudents() throws Exception{
		List<StudentVO> studentVOList = new ArrayList<StudentVO>(); 
		List<Student> studentEntityList = studentRespository.findAll();
		
		for(Student studentEntity : studentEntityList) {
			Department deptEntity = studentEntity.getDept();
			DepartmentVO deptVO = new DepartmentVO(deptEntity.getDepartmentId(), deptEntity.getDepartmentName());
			
			StudentVO vo = new StudentVO(studentEntity.getStudentId(), studentEntity.getStudentName());
			vo.setDept(deptVO);
			studentVOList.add(vo);
		}
		
		return studentVOList;
	}

	@Override
	public StudentVO saveStudent(StudentVO studentVO) throws Exception {
		DepartmentVO departmentVO = studentVO.getDept();
		
		Student studentEntity = new Student(studentVO.getStudentId(), studentVO.getStudentName());
		studentEntity.setDept(new Department(departmentVO.getDepartmentId(), departmentVO.getDepartmentName()));
		
		studentEntity = studentRespository.save(studentEntity);
		Department deptEntity = studentEntity.getDept();
		departmentVO = new DepartmentVO(deptEntity.getDepartmentId(), deptEntity.getDepartmentName()); 
		studentVO = new StudentVO(studentEntity.getStudentId(), studentEntity.getStudentName(), departmentVO);
		
		return studentVO;
	}
}
