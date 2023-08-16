package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.CoordinatorDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.Coordinator;
import BeatrizCesconettoSchool.scholarship.repositry.CoordinatorRepository;
import BeatrizCesconettoSchool.scholarship.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.io.IOException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CoordinatorServiceTest {

    @InjectMocks
    private CoordinatorService coordinatorService;

    @Mock
    private CoordinatorRepository coordinatorRepository;

    @Spy
    private ModelMapper modelMapper;

    private static final String COORDINATORDTO = "Scholarship/coordinatordto.json";
    private static final String COORDINATOR = "Scholarship/coordinator.json";


    @Test
    void registerCoordinator() throws IOException {
        CoordinatorDtoRequest dtoRequest =JsonUtils.getObjectFromFile(COORDINATORDTO,CoordinatorDtoRequest.class);
        Coordinator coordinator = JsonUtils.getObjectFromFile(COORDINATOR, Coordinator.class);
        CoordinatorDtoResponse dtoResponse = JsonUtils.getObjectFromFile(COORDINATOR,CoordinatorDtoResponse.class);

        when(coordinatorRepository.save(any())).thenReturn(coordinator);
        CoordinatorDtoResponse response = coordinatorService.registerCoordinator(dtoRequest);

        assertNotNull(response);
        assertEquals(response.getId(),dtoResponse.getId());
    }

    @Test
    void findById() {
        Long id = 1L;
        Coordinator coordinator = new Coordinator();

        when(coordinatorRepository.findById(id)).thenReturn(Optional.of(coordinator));

        Coordinator result = coordinatorService.findById(id);

        assertNotNull(result);
        assertEquals(coordinator, result);

        }
    }
