package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.SquadDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.SquadDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Squad;
import BeatrizCesconettoSchool.scholarship.entity.Student;
import BeatrizCesconettoSchool.scholarship.repositry.SquadRepository;
import BeatrizCesconettoSchool.scholarship.repositry.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SquadService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    StudentRepository studentRepository;

    private final SquadRepository squadRepository;

    public SquadService(SquadRepository squadRepository) {
        this.squadRepository = squadRepository;
    }

    public SquadDtoResponse registerSquad (SquadDtoRequest squadDtoRequest) {

        List < Student> students = studentRepository.findAllById(squadDtoRequest.getStudents());

        Squad squad = new Squad();
        squad.setName(squad.getName());
        squad.setStudents(students);

        Squad squadSaved = squadRepository.save(squad);

        return mapper.map(squadSaved, SquadDtoResponse.class);
    }
}
