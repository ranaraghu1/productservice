package com.rana.springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
	Student student=new Student();
	student.setFirstName("Devi");
	student.setLastName("Mishara");
	student.setScore(76);
	
	Student student2=new Student();
	student2.setFirstName("Barun");
	student2.setLastName("Ray");
	student2.setScore(95);
	
	studentRepo.save(student);
	studentRepo.save(student2);
	
	}
	
	@Test
	public void testFindAllStudent() {
		
		List<Student> students=studentRepo.findAllStudents();
		students.forEach(student->System.out.println(student.getFirstName()));
		
	}

}
