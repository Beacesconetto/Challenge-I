package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.SquadDto;
import BeatrizCesconettoSchool.scholarship.repositry.SquadRepository;
import BeatrizCesconettoSchool.scholarship.service.SquadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/squad")
public class SquadController {

    @Autowired
    private SquadRepository squadRepository;

    private final SquadService squadService;

    public SquadController(SquadService squadService) {
        this.squadService = squadService;
    }

    @PostMapping
    public ResponseEntity <SquadDto> newSquad(@Valid@RequestBody SquadDto squadDto) {
        squadService.registerSquad(squadDto);

        return ResponseEntity.ok(squadDto);

    }


}
