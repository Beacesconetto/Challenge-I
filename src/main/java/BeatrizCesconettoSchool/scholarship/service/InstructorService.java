package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.InstructorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.InstructorDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Instructor;
import BeatrizCesconettoSchool.scholarship.repositry.InstructorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {


    private final ModelMapper modelMapper;

    private final InstructorRepository instructorRepository;

    public InstructorService(ModelMapper modelMapper, InstructorRepository instructorRepository) {
        this.modelMapper = modelMapper;
        this.instructorRepository = instructorRepository;
    }

    public InstructorDtoResponse registerInstructor (InstructorDtoRequest instructorDtoRequest) {

            Instructor instructor = modelMapper.map(instructorDtoRequest, Instructor.class);
            Instructor instructorSaved = instructorRepository.save(instructor);

        return modelMapper.map(instructorSaved, InstructorDtoResponse.class);
    }
}



