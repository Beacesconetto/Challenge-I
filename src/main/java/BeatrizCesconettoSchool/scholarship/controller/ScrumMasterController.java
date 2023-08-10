package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.ScrumMasterDto;
import BeatrizCesconettoSchool.scholarship.repositry.ScrumMasterRepository;
import BeatrizCesconettoSchool.scholarship.service.ScrumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity <ScrumMasterDto> newscrumMaster (ScrumMasterDto scrumMasterDto){
        scrumMasterService.registerscrumMaster(scrumMasterDto);

        return ResponseEntity.ok(scrumMasterDto);
    }
}
