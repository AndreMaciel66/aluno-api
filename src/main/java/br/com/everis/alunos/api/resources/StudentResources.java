package br.com.everis.alunos.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.everis.alunos.api.dao.StudentDAO;
import br.com.everis.alunos.api.domain.Student;

@RestController
@RequestMapping(path = "/api/v1/alunos")
public class StudentResources {
	
	@Autowired
	private StudentDAO studentDao;

	@GetMapping(produces = "application/json")
	public List<Student> getStudents() {
		return studentDao.findAll();
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addStudent(@RequestBody Student student) throws Exception {
		studentDao.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
