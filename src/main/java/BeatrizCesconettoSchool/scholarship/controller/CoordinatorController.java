package BeatrizCesconettoSchool.scholarship.controller;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoResponse;
import BeatrizCesconettoSchool.scholarship.repositry.CoordinatorRepository;
import BeatrizCesconettoSchool.scholarship.service.CoordinatorService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coordinator")
public class CoordinatorController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    private final CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @PostMapping
    public ResponseEntity<CoordinatorDtoResponse> newCoordinator(@Valid @RequestBody CoordinatorDtoRequest coordinatorDtoRequest) {
        CoordinatorDtoResponse coordinatorDtoSave = coordinatorService.registerCoordinator(coordinatorDtoRequest);

        return new ResponseEntity<>(coordinatorDtoSave, HttpStatus.CREATED);
    }

    //pra fazer get
    @GetMapping(value = "/get/{id}")
    public ResponseEntity <CoordinatorDtoResponse> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(mapper.map(coordinatorService.findById(id), CoordinatorDtoResponse.class));
    }
}
