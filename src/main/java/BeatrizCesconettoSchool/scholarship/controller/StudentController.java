package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.StudentDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.StudentDtoResponse;
import BeatrizCesconettoSchool.scholarship.repositry.StudentRepository;
import BeatrizCesconettoSchool.scholarship.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity <StudentDtoResponse> newStudent(@Valid@RequestBody StudentDtoRequest studentDtoRequest) {
        StudentDtoResponse  studeentDtoSave = studentService.registerStudent(studentDtoRequest);

        return new ResponseEntity<>(studeentDtoSave, HttpStatus.CREATED) ;
    }
}
