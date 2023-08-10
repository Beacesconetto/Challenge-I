package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDto;
import BeatrizCesconettoSchool.scholarship.repositry.CoordinatorRepository;
import BeatrizCesconettoSchool.scholarship.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="coordinator")
public class CoordinatorController {

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    private final CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @PostMapping
    public ResponseEntity<CoordinatorDto> newCoordinator(CoordinatorDto coordinatorDto) {
        coordinatorService.registerCoordinator(coordinatorDto);

        return  ResponseEntity.ok(coordinatorDto);
    }
}
