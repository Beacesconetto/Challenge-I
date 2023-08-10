package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.SquadDto;
import BeatrizCesconettoSchool.scholarship.entity.Squad;
import BeatrizCesconettoSchool.scholarship.repositry.SquadRepository;
import org.springframework.stereotype.Service;

@Service
public class SquadService {

    private final SquadRepository squadRepository;

    public SquadService(SquadRepository squadRepository) {
        this.squadRepository = squadRepository;
    }

    public Squad registerSquad (SquadDto squadDto) {

        Squad squad = new Squad();
        squad.setName(squad.getName());

        squadRepository.save(squad);

        return squad;

    }
}
