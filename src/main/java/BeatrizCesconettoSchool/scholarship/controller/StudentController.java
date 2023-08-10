package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.StudentDto;
import BeatrizCesconettoSchool.scholarship.repositry.StudentRepository;
import BeatrizCesconettoSchool.scholarship.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity <StudentDto> newStudent(@Valid@RequestBody StudentDto studentDto) {
        studentService.registerStudent(studentDto);

        return ResponseEntity.ok(studentDto);
    }
}
