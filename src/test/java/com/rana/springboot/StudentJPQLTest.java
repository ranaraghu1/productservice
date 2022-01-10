package com.rana.springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort.Direction;

import org.springframework.test.context.junit4.SpringRunner;

import com.rana.springboot.entites.Student;
import com.rana.springboot.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentJPQLTest {
	@Autowired
	StudentRepository studentRepo;

	@Test
	public void testStudentScore() {
		Student student = new Student();
		student.setFirstName("Devi");
		student.setLastName("Mishara");
		student.setScore(76);

		Student student2 = new Student();
		student2.setFirstName("Barun");
		student2.setLastName("Ray");
		student2.setScore(95);

		studentRepo.save(student);
		studentRepo.save(student2);

	}

	// JPQL
	@Test
	public void testFindAllStudent() {

     //0=page 1,1=page2
		//List<Student> students = studentRepo.findAllStudents(PageRequest.of(0, 2));
		
		List<Student> students = studentRepo.findAllStudents(PageRequest.of(0, 4,Direction.DESC,"score"));
		
		students.forEach(student -> System.out.println(student.getFirstName()));
	
			        

	}

	// JPQL-Named Query param
	@Test
	public void tetFindAllStudentsByFirstname() {

		List<Student> students = studentRepo.findAllStudentsByFirstname("Raghu");
		students.forEach(student -> System.out.println(student.getLastName()));

	}

	// JPQL
	@Test
	public void testFindAllStudentsPartialDate() {
		List<Object[]> students = studentRepo.findAllStudentsPartialDate();
		for (Object[] objects : students) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);

		}
	}
	
	// Native-SQL
		@Test
		public void testFindAllStudentNQ() {
			System.out.println(studentRepo.findAllStudentNQ());
		}

}
