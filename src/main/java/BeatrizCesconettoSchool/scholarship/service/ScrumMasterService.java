package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.ScrumMasterDto;
import BeatrizCesconettoSchool.scholarship.entity.ScrumMaster;
import BeatrizCesconettoSchool.scholarship.repositry.ScrumMasterRepository;
import org.springframework.stereotype.Service;

@Service
public class ScrumMasterService {

    private final ScrumMasterRepository scrumMasterRepository;

    public ScrumMasterService(ScrumMasterRepository scrumMasterRepository) {
        this.scrumMasterRepository = scrumMasterRepository;
    }

    public ScrumMaster registerscrumMaster(ScrumMasterDto scrumMasterDto) {

        ScrumMaster scrumMaster = new ScrumMaster();
        scrumMaster.setName(scrumMaster.getName());
        scrumMaster.setLastname(scrumMaster.getLastname());
        scrumMaster.setEmail(scrumMaster.getEmail());

        scrumMasterRepository.save(scrumMaster);

        return scrumMaster;
    }
}
