package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoResponse;
import BeatrizCesconettoSchool.scholarship.dto.SquadDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.SquadDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Coordinator;
import BeatrizCesconettoSchool.scholarship.entity.Squad;
import BeatrizCesconettoSchool.scholarship.entity.Student;
import BeatrizCesconettoSchool.scholarship.repositry.ScrumMasterRepository;
import BeatrizCesconettoSchool.scholarship.repositry.SquadRepository;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SquadServiceTest {


    @InjectMocks
    private SquadService squadService;

    @Mock
    private SquadRepository squadRepository;

    @Mock
    private StudentRepository studentRepository;

    @Spy
    private ModelMapper modelMapper;

    private  static final String SQUADDTO = "Scholarship/squaddto.json";
    private  static final String SQUAD = "Scholarship/squad.json";
    private  static final String SQUADREQUEST = "Scholarship/squadrequest.json";
    private  static final String SQUADSTUDENTS = "Scholarship/squadStudents.json";


    @Test
    void registerSquad () throws IOException {

        SquadDtoRequest dtoRequest = JsonUtils.getObjectFromFile(SQUADREQUEST,SquadDtoRequest.class);
        Student [] students =JsonUtils.getObjectFromFile(SQUADSTUDENTS,Student[].class);
        Squad squad = JsonUtils.getObjectFromFile(SQUAD,Squad.class);
        SquadDtoResponse dtoResponse = JsonUtils.getObjectFromFile(SQUAD,SquadDtoResponse.class);

        when(studentRepository.findAllById(any())).thenReturn(List.of(students));
        when(squadRepository.save(any())).thenReturn(squad);
        SquadDtoResponse response = squadService.registerSquad(dtoRequest);


        assertNotNull(response);
        assertEquals(response.getId(),dtoResponse.getId());

    }



}