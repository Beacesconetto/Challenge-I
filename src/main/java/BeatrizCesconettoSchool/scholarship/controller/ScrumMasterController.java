package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.ScrumMasterDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.ScrumMasterDtoResponse;
import BeatrizCesconettoSchool.scholarship.repositry.ScrumMasterRepository;
import BeatrizCesconettoSchool.scholarship.service.ScrumMasterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scrummaster")
public class ScrumMasterController {

    @Autowired
    private ScrumMasterRepository scrumMasterRepository;

    private final ScrumMasterService scrumMasterService;

    public ScrumMasterController(ScrumMasterService scrumMasterService) {
        this.scrumMasterService = scrumMasterService;
    }

    @PostMapping
    public ResponseEntity <ScrumMasterDtoResponse> newscrumMaster (@Valid @RequestBody ScrumMasterDtoRequest scrumMasterDtoRequest){

        ScrumMasterDtoResponse scrumMasterDtoSave = scrumMasterService.registerscrumMaster(scrumMasterDtoRequest);

        return new ResponseEntity<>(scrumMasterDtoSave, HttpStatus.CREATED);
    }
}
