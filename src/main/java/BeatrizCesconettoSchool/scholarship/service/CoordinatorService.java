package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Coordinator;
import BeatrizCesconettoSchool.scholarship.repositry.CoordinatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoordinatorService {



    private final ModelMapper modelMapper;

    private final CoordinatorRepository coordinatorRepository;

    public CoordinatorService(ModelMapper modelMapper, CoordinatorRepository coordinatorRepository) {
        this.modelMapper = modelMapper;
        this.coordinatorRepository = coordinatorRepository;
    }

    public CoordinatorDtoResponse registerCoordinator (CoordinatorDtoRequest coordinatorDtoRequest) {

        Coordinator coordinator =  modelMapper.map(coordinatorDtoRequest, Coordinator.class);
        Coordinator coordinatorSaved = coordinatorRepository.save(coordinator);

        return modelMapper.map(coordinatorSaved, CoordinatorDtoResponse.class);
    }

    public Coordinator findById(Long id) {
        Optional <Coordinator> obj = coordinatorRepository.findById(id);

        return obj.orElse(null);
    }
}
