package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDto;
import BeatrizCesconettoSchool.scholarship.entity.Coordinator;
import BeatrizCesconettoSchool.scholarship.entity.Student;
import BeatrizCesconettoSchool.scholarship.repositry.CoordinatorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CoordinatorService {

    private final CoordinatorRepository coordinatorRepository;

    public CoordinatorService(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    public Coordinator registerCoordinator (CoordinatorDto coordinatorDto) {

        Coordinator coordinator = new Coordinator();
        coordinator.setName(coordinator.getName());
        coordinator.setLastname(coordinator.getLastname());
        coordinator.setEmail(coordinator.getEmail());

        coordinatorRepository.save(coordinator);

        return coordinator;
    }
}
