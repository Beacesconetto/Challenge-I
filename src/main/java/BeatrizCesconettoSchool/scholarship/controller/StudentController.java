package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.StudentDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.StudentDtoResponse;
import BeatrizCesconettoSchool.scholarship.repositry.StudentRepository;
import BeatrizCesconettoSchool.scholarship.service.StudentService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/students")
public class StudentController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private StudentRepository studentRepository;

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity <StudentDtoResponse> newStudent(@Valid@RequestBody StudentDtoRequest studentDtoRequest) {
        StudentDtoResponse  studentDtoSave = studentService.registerStudent(studentDtoRequest);

        return new ResponseEntity<>(studentDtoSave, HttpStatus.CREATED) ;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<StudentDtoResponse> getStudentById(@PathVariable Long id) {

        return ResponseEntity.ok().body(mapper.map(studentService.getStudentById(id),StudentDtoResponse.class));
    }
}
