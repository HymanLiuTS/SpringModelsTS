package springmvcdemo.courseselection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvcdemo.authentication.model.User;
import springmvcdemo.authentication.repository.UserRepository;
import springmvcdemo.business.model.Student;
import springmvcdemo.business.repository.StudentRepository;
import springmvcdemo.common.domain.Result;

@Service("courseSelectionService")
public class CourseSelectionService {

	@Autowired
	@Qualifier("studentRepository")
	private StudentRepository studentRepository;
	
	
	public Student save(Student student) {
		return this.studentRepository.save(student);
	}
	
}
