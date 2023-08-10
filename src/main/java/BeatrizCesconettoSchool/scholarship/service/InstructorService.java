package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.InstructorDto;
import BeatrizCesconettoSchool.scholarship.entity.Instructor;
import BeatrizCesconettoSchool.scholarship.repositry.InstructorRepository;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor registerInstructor (InstructorDto instructorDto) {

        Instructor instructor = new Instructor();
        instructor.setName(instructor.getName());
        instructor.setLastname(instructor.getLastname());
        instructor.setEmail(instructor.getEmail());

        instructorRepository.save(instructor);

        return instructor;
    }
}
