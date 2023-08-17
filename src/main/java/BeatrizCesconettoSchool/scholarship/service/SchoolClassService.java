package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDtoRequest;
import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDtoResponse;
import BeatrizCesconettoSchool.scholarship.entity.*;
import BeatrizCesconettoSchool.scholarship.exception.SchoolClassNotFoundException;
import BeatrizCesconettoSchool.scholarship.repositry.*;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolClassService {


    private final ModelMapper mapper;


    private final ScrumMasterRepository scrumMasterRepository;


    private final CoordinatorRepository coordinatorRepository;


    private final InstructorRepository instructorRepository;


    private final SchoolClassRepository schoolClassRepository;


    private final StudentRepository studentRepository;

    public SchoolClassService(ModelMapper mapper, ScrumMasterRepository scrumMasterRepository, CoordinatorRepository coordinatorRepository, InstructorRepository instructorRepository, SchoolClassRepository schoolClassRepository, StudentRepository studentRepository) {
        this.mapper = mapper;
        this.scrumMasterRepository = scrumMasterRepository;
        this.coordinatorRepository = coordinatorRepository;
        this.instructorRepository = instructorRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.studentRepository = studentRepository;
    }


    public SchoolClassDtoResponse registerSchoolClass(SchoolClassDtoRequest schoolClassDtoRequest) {

        Optional<Coordinator> coordinator = coordinatorRepository.findById(schoolClassDtoRequest.getCoordinator());
        Optional<ScrumMaster> scrumMaster = scrumMasterRepository.findById(schoolClassDtoRequest.getScrumMaster());
        List <Instructor> instructors = instructorRepository.findAllById(schoolClassDtoRequest.getInstructors());
        List <Student> students = studentRepository.findAllById(schoolClassDtoRequest.getStudents());

        SchoolClass schoolClass = new SchoolClass(schoolClassDtoRequest.getName());

        schoolClass.setCoordinator(coordinator.get());
        schoolClass.setScrumMaster(scrumMaster.get());
        schoolClass.getInstructors().addAll(instructors);
        schoolClass.getStudents().addAll(students);

        for (Student student : students) {
            student.setSchoolClass(schoolClass);
        }

        for (Instructor instructor : instructors) {
            instructor.setSchoolClass(schoolClass);
        }

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

    public SchoolClassDtoResponse getSchoolClassById(Long id) {

       SchoolClass schoolClass = schoolClassRepository.findById(id)
               .orElseThrow(()->new SchoolClassNotFoundException("School Class id not found"));

        return mapper.map(schoolClass,SchoolClassDtoResponse.class);
    }
}
