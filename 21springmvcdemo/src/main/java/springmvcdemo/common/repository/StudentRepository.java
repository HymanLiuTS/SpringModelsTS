package springmvcdemo.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springmvcdemo.courseselection.model.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {

}
