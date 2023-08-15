package BeatrizCesconettoSchool.scholarship.service;


import BeatrizCesconettoSchool.scholarship.dto.StudentDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.StudentDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Student;
import BeatrizCesconettoSchool.scholarship.repositry.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private ModelMapper modelMapper;
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDtoResponse registerStudent(StudentDtoRequest studentDtoRequest) {

        Student student = modelMapper.map(studentDtoRequest, Student.class);

        Student studentSaved = studentRepository.save(student);

        return modelMapper.map(studentSaved,StudentDtoResponse.class) ;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


}
