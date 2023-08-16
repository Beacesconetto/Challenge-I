package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.ScrumMasterDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.ScrumMasterDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.ScrumMaster;
import BeatrizCesconettoSchool.scholarship.repositry.ScrumMasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ScrumMasterService {


    private final ModelMapper modelMapper;

    private final ScrumMasterRepository scrumMasterRepository;

    public ScrumMasterService(ModelMapper modelMapper, ScrumMasterRepository scrumMasterRepository) {
        this.modelMapper = modelMapper;
        this.scrumMasterRepository = scrumMasterRepository;
    }

    public ScrumMasterDtoResponse registerscrumMaster(ScrumMasterDtoRequest scrumMasterDtoRequest) {

        ScrumMaster scrumMaster = modelMapper.map(scrumMasterDtoRequest, ScrumMaster.class);

       ScrumMaster scrumMasterSaved = scrumMasterRepository.save(scrumMaster);

        return modelMapper.map(scrumMasterSaved, ScrumMasterDtoResponse.class);
    }
}
