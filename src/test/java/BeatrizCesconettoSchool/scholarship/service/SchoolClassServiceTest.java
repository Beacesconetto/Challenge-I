package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoResponse;
import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.*;
import BeatrizCesconettoSchool.scholarship.repositry.*;
import BeatrizCesconettoSchool.scholarship.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SchoolClassServiceTest {

    @InjectMocks
    private SchoolClassService schoolClassService;

    @Mock
    private SchoolClassRepository schoolClassRepository;
    @Mock
    private ScrumMasterRepository scrumMasterRepository;

    @Mock
    private CoordinatorRepository coordinatorRepository;

    @Mock
    private InstructorRepository instructorRepository;
    @Mock
    private StudentRepository studentRepository;
    @Spy
    private ModelMapper modelMapper;

    private static final String SCHOOLCLASSDTO = "Scholarship/schoolclassdto.json";
    private static final String SCHOOLCLASS = "Scholarship/schoolclass.json";
    private static final String COORDINATOR = "Scholarship/coordinator.json";
    private static final String SCRUMMASTER = "Scholarship/scrummaster.json";
    private static final String STUDENT = "Scholarship/squadStudents.json";
    private static final String INSTRUCTOR = "Scholarship/schoolclassinstructor.json";

    @Test
    void registerSchoolClass() throws IOException {
        SchoolClassDtoRequest dtoRequest = JsonUtils.getObjectFromFile(SCHOOLCLASSDTO,SchoolClassDtoRequest.class);
        Coordinator coordinator = JsonUtils.getObjectFromFile(COORDINATOR, Coordinator.class);
        ScrumMaster scrumMaster = JsonUtils.getObjectFromFile(SCRUMMASTER,ScrumMaster.class);
        Student [] students = JsonUtils.getObjectFromFile(STUDENT,Student[].class);
        Instructor [] instructors = JsonUtils.getObjectFromFile(INSTRUCTOR,Instructor[].class);
        SchoolClass schoolClass = JsonUtils.getObjectFromFile(SCHOOLCLASS, SchoolClass.class);
        SchoolClassDtoResponse dtoResponse = JsonUtils.getObjectFromFile(SCHOOLCLASS,SchoolClassDtoResponse.class);



        when(coordinatorRepository.findById(any())).thenReturn(Optional.ofNullable(coordinator));
        when(scrumMasterRepository.findById(any())).thenReturn(Optional.ofNullable(scrumMaster));
        when(studentRepository.findAllById(any())).thenReturn(List.of(students));
        when(instructorRepository.findAllById(any())).thenReturn(List.of(instructors));
        when(schoolClassRepository.save(any())).thenReturn(schoolClass);

        SchoolClassDtoResponse Dtoresponse = schoolClassService.registerSchoolClass(dtoRequest);
        assertNotNull(Dtoresponse);
        assertEquals(Dtoresponse.getId(),Dtoresponse.getId());

    }

    @Test
    void start() throws IOException {
        SchoolClass schoolClass =JsonUtils.getObjectFromFile(SCHOOLCLASS,SchoolClass.class);

        when(schoolClassRepository.findById(any())).thenReturn(Optional.ofNullable(schoolClass));
        schoolClassService.start(schoolClass.getId());

        assertEquals(schoolClass.getStatusClass(), StatusClass.STARTED);

    }

    @Test
    void finish() throws IOException {
        SchoolClass schoolClass =JsonUtils.getObjectFromFile(SCHOOLCLASS,SchoolClass.class);

        when(schoolClassRepository.findById(any())).thenReturn(Optional.ofNullable(schoolClass));
        schoolClassService.finish(schoolClass.getId());

        assertEquals(schoolClass.getStatusClass(), StatusClass.FINISHED);
    }

    @Test
    void getSchoolClassById() throws IOException {
        Long classId = 1L;

        SchoolClass schoolClass =JsonUtils.getObjectFromFile(SCHOOLCLASS,SchoolClass.class);

        when(schoolClassRepository.findById(any())).thenReturn(Optional.of(schoolClass));

        SchoolClassDtoResponse result = schoolClassService.getSchoolClassById(classId);

        assertNotNull(result);
        assertEquals(schoolClass.getId(), result.getId());
    }
}