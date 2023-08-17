package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoResponse;
import BeatrizCesconettoSchool.scholarship.dto.StudentDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.StudentDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Coordinator;
import BeatrizCesconettoSchool.scholarship.entity.Student;
import BeatrizCesconettoSchool.scholarship.repositry.StudentRepository;
import BeatrizCesconettoSchool.scholarship.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Spy
    private ModelMapper modelMapper;

    private static final String STUDENTDTO = "Scholarship/studentdto.json";
    private static final String STUDENT = "Scholarship/student.json";





    @Test
    void registerStudent() throws IOException {
        StudentDtoRequest dtoRequest = JsonUtils.getObjectFromFile(STUDENTDTO,StudentDtoRequest.class);
        Student student = JsonUtils.getObjectFromFile(STUDENT, Student.class);
        StudentDtoResponse dtoResponse = JsonUtils.getObjectFromFile(STUDENT, StudentDtoResponse.class);

        when(studentRepository.save(any())).thenReturn(student);
        StudentDtoResponse response = studentService.registerStudent(dtoRequest);

        assertNotNull(response);
        assertEquals(response.getId(),dtoResponse.getId());
    }

    @Test
    void getStudentById() {
        Long id = 1L;
        Student student = new Student();

        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        Student result = studentService.getStudentById(id);

        assertNotNull(result);
        assertEquals(student, result);
    }
}