package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDto;
import BeatrizCesconettoSchool.scholarship.repositry.SchoolClassRepository;
import BeatrizCesconettoSchool.scholarship.service.SchoolClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SchoolClass")
public class SchoolClassController {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping
    public ResponseEntity<SchoolClassDto> newSchoolClass(@Valid @RequestBody SchoolClassDto schoolClassDto) {
        schoolClassService.registerSchoolClass(schoolClassDto);

        return ResponseEntity.ok(schoolClassDto);
    }
}
