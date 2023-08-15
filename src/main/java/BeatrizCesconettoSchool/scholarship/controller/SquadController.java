package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.SquadDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.SquadDtoResponse;
import BeatrizCesconettoSchool.scholarship.repositry.SquadRepository;
import BeatrizCesconettoSchool.scholarship.service.SquadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/squads")
public class SquadController {

    @Autowired
    private SquadRepository squadRepository;

    private final SquadService squadService;

    public SquadController(SquadService squadService) {
        this.squadService = squadService;
    }

    @PostMapping
    public ResponseEntity <SquadDtoResponse> newSquad(@Valid@RequestBody SquadDtoRequest squadDtoRequest) {
       SquadDtoResponse squadSave = squadService.registerSquad(squadDtoRequest);

        return new ResponseEntity<>(squadSave, HttpStatus.CREATED);

    }


}
