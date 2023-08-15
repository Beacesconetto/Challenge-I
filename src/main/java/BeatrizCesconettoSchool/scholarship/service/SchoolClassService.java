package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.*;
import BeatrizCesconettoSchool.scholarship.exception.SchoolClassNotFoundException;
import BeatrizCesconettoSchool.scholarship.repositry.*;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolClassService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ScrumMasterRepository scrumMasterRepository;

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private  SchoolClassRepository schoolClassRepository;

    @Autowired
    private StudentRepository studentRepository;


    public SchoolClassDtoResponse registerSchoolClass(SchoolClassDtoRequest schoolClassDtoRequest) {

        Optional<Coordinator> coordinator = coordinatorRepository.findById(schoolClassDtoRequest.getCoordinator());
        Optional<ScrumMaster> scrumMaster = scrumMasterRepository.findById(schoolClassDtoRequest.getScrumMaster());
        List <Instructor> instructors = instructorRepository.findAllById(schoolClassDtoRequest.getInstructors());
        List <Student> students = studentRepository.findAllById(schoolClassDtoRequest.getStudents());

        SchoolClass schoolClass = new SchoolClass(schoolClassDtoRequest.getName());

        schoolClass.setCoordinator(coordinator.get());
        schoolClass.setScrumMaster(scrumMaster.get());
        schoolClass.setInstructors(instructors);
        schoolClass.setStudents(students);

        SchoolClass schoolClassSaved = schoolClassRepository.save(schoolClass);

        return mapper.map(schoolClassSaved,SchoolClassDtoResponse.class);


    }

    private ScrumMaster findScrumMasterById(Long scrumMasterId) {
        return scrumMasterRepository .findById(scrumMasterId)
                .orElseThrow(() -> new EntityNotFoundException("Scrum Master not found"));
    }




    public void start(Long id) {
        Optional<SchoolClass> optionalSchoolClass = schoolClassRepository.findById(id);

        if (optionalSchoolClass.isPresent()) {
            SchoolClass schoolClass = optionalSchoolClass.get();
            schoolClass.setStatusClass(StatusClass.STARTED);
        } else {
           throw new SchoolClassNotFoundException("SchoolCLass not found with id: " +id);
        }
    }



    public void finish(Long id) {
        Optional<SchoolClass> optionalSchoolClass = schoolClassRepository.findById(id);

        if (optionalSchoolClass.isPresent()) {
            SchoolClass schoolClass = optionalSchoolClass.get();
            schoolClass.setStatusClass(StatusClass.FINISHED);
        } else {
            throw new SchoolClassNotFoundException("SchoolCLass not found with id: " + id);
        }

    }
}
