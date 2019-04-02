package springmvcdemo.courseselection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvcdemo.authentication.model.User;
import springmvcdemo.common.domain.Result;
import springmvcdemo.common.repository.StudentRepository;
import springmvcdemo.common.repository.UserRepository;
import springmvcdemo.courseselection.model.Student;

@Service("courseSelectionService")
public class CourseSelectionService {

	@Autowired
	@Qualifier("studentRepository")
	private StudentRepository studentRepository;
	
	
	public Student save(Student student) {
		return this.studentRepository.save(student);
	}
	
}
