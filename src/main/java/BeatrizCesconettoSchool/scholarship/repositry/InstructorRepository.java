package BeatrizCesconettoSchool.scholarship.repositry;

import BeatrizCesconettoSchool.scholarship.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository <Instructor, Long> {
}
