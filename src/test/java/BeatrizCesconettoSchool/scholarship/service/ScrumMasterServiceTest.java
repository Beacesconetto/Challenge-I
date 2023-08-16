package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoResponse;
import BeatrizCesconettoSchool.scholarship.dto.ScrumMasterDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.ScrumMasterDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Coordinator;
import BeatrizCesconettoSchool.scholarship.entity.ScrumMaster;
import BeatrizCesconettoSchool.scholarship.repositry.ScrumMasterRepository;
import BeatrizCesconettoSchool.scholarship.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScrumMasterServiceTest {

    @InjectMocks
    private ScrumMasterService scrumMasterService;

    @Mock
    private ScrumMasterRepository scrumMasterRepository;

    @Spy
    private ModelMapper modelMapper;

    private static final String SCRUMMASTERDTO = "Scholarship/scrummasterdto.json";
    private static final String SCRUMMASTER = "Scholarship/scrummaster.json";

    @Test
    void  registerScrumMaster() throws IOException {
        ScrumMasterDtoRequest dtoRequest = JsonUtils.getObjectFromFile(SCRUMMASTERDTO,ScrumMasterDtoRequest.class);
        ScrumMaster scrumMaster = JsonUtils.getObjectFromFile(SCRUMMASTER, ScrumMaster.class);
        ScrumMasterDtoResponse dtoResponse = JsonUtils.getObjectFromFile(SCRUMMASTER,ScrumMasterDtoResponse.class);

        when(scrumMasterRepository.save(any())).thenReturn(scrumMaster);
        ScrumMasterDtoResponse response = scrumMasterService.registerscrumMaster(dtoRequest);

        assertNotNull(response);
        assertEquals(response.getId(), dtoResponse.getId());
    }
}