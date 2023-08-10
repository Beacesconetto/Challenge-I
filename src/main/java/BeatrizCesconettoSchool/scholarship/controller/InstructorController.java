package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.InstructorDto;
import BeatrizCesconettoSchool.scholarship.repositry.InstructorRepository;
import BeatrizCesconettoSchool.scholarship.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/instructor")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    public ResponseEntity <InstructorDto> newInstructor (InstructorDto instructorDto) {
        instructorService.registerInstructor(instructorDto);

        return ResponseEntity.ok(instructorDto);
    }
}
