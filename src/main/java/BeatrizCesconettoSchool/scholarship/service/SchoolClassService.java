package BeatrizCesconettoSchool.scholarship.service;

import BeatrizCesconettoSchool.scholarship.dto.SchoolClassDto;
import BeatrizCesconettoSchool.scholarship.entity.SchoolClass;
import BeatrizCesconettoSchool.scholarship.entity.StatusClass;
import BeatrizCesconettoSchool.scholarship.entity.Student;
import BeatrizCesconettoSchool.scholarship.repositry.SchoolClassRepository;
import BeatrizCesconettoSchool.scholarship.repositry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolClassService {

    @Autowired
    private  SchoolClassRepository schoolClassRepository;

    @Autowired
    private StudentRepository studentRepository;


    public SchoolClass registerSchoolClass(SchoolClassDto schoolClassDto) {

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName(schoolClass.getName());
        schoolClass.setStatusClass(StatusClass.WAITING);

        schoolClassRepository.save(schoolClass);

        return schoolClass;
    }

    public Student creatStudent(String name, String lastname, String email,SchoolClass schoolClass){

        Student student = new Student();
        student.setName(name);
        student.setLastname(lastname);
        student.setEmail(email);

        schoolClass.getStudents().add(student);
        student.setSchoolClass(schoolClass);

        schoolClassRepository.save(schoolClass);

        return studentRepository.save(student);
    }




}
