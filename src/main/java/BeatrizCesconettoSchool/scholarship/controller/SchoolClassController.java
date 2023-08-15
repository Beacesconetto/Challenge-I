package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDtoResponse;
import BeatrizCesconettoSchool.scholarship.dto.StudentDtoResponse;
import BeatrizCesconettoSchool.scholarship.repositry.SchoolClassRepository;
import BeatrizCesconettoSchool.scholarship.service.SchoolClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schoolclass")
public class SchoolClassController {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping
    public ResponseEntity<SchoolClassDtoResponse> newSchoolClass(@Valid @RequestBody SchoolClassDtoRequest schoolClassDtoRequest) {

        SchoolClassDtoResponse schoolclassdtoSave = schoolClassService.registerSchoolClass(schoolClassDtoRequest);

        return new ResponseEntity<>(schoolclassdtoSave, HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}/started")
    public ResponseEntity<Void> startClass(@PathVariable Long id){
        schoolClassService.start(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}/finished")
    public ResponseEntity<Void> finishClass(@PathVariable Long id){
        schoolClassService.finish(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
