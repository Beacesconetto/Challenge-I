package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.InstructorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.InstructorDtoResponse;
import BeatrizCesconettoSchool.scholarship.repositry.InstructorRepository;
import BeatrizCesconettoSchool.scholarship.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/instructors")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity <InstructorDtoResponse> newInstructor (@Valid @RequestBody InstructorDtoRequest instructorDtoRequest) {

        InstructorDtoResponse instructorDtoSave = instructorService.registerInstructor(instructorDtoRequest);


        return new ResponseEntity <> (instructorDtoSave, HttpStatus.CREATED);
    }
}
