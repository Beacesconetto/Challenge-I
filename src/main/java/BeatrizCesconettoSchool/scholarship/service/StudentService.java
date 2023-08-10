package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.StudentDto;
import BeatrizCesconettoSchool.scholarship.entity.Student;
import BeatrizCesconettoSchool.scholarship.repositry.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student registerStudent(StudentDto studentDto) {

        Student student = new Student();
        student.setName(student.getName());
        student.setLastname(student.getLastname());
        student.setEmail(student.getEmail());

        studentRepository.save(student);

        return  student;
    }
}
