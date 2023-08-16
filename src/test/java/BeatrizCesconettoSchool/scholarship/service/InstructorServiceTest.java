package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoResponse;
import BeatrizCesconettoSchool.scholarship.dto.InstructorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.InstructorDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Coordinator;
import BeatrizCesconettoSchool.scholarship.entity.Instructor;
import BeatrizCesconettoSchool.scholarship.repositry.InstructorRepository;
import BeatrizCesconettoSchool.scholarship.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorServiceTest {
    @InjectMocks
    private InstructorService instructorService;

    @Mock
    private InstructorRepository instructorRepository;

    @Spy
    private ModelMapper modelMapper;


    private  static final  String INSTRUCTORDTO = "Scholarship/instructordto.json";
    private  static  final String INSTRUCTOR = "Scholarship/instructor.json";


    @Test
    void registerInstructor() throws IOException {
        InstructorDtoRequest dtoRequest = JsonUtils.getObjectFromFile(INSTRUCTORDTO,InstructorDtoRequest.class);
        Instructor instructor = JsonUtils.getObjectFromFile(INSTRUCTOR, Instructor.class);
        InstructorDtoResponse dtoResponse = JsonUtils.getObjectFromFile(INSTRUCTOR, InstructorDtoResponse.class);

        when(instructorRepository.save(any())).thenReturn(instructor);
        InstructorDtoResponse response = instructorService.registerInstructor(dtoRequest);

        assertNotNull(response);
        assertEquals(response.getId(),dtoResponse.getId());
    }
}