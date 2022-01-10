package com.rana.springboot.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rana.springboot.entites.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	//JPQL
	@Query("from Student")
    List<Student> findAllStudents(Pageable pageable);
	
	@Query("from Student st where st.firstName=:firstName")
	List<Student> findAllStudentsByFirstname(@Param("firstName") String firstName);
	
	@Query("select st.firstName,st.lastName from Student st")
	List<Object[]> findAllStudentsPartialDate();
	
	//Native- SQL
	@Query(value="select * from student",nativeQuery=true)
	List<Student> findAllStudentNQ();
}
