package BeatrizCesconettoSchool.scholarship.repositry;

import BeatrizCesconettoSchool.scholarship.entity.Instructor;
import BeatrizCesconettoSchool.scholarship.entity.ScrumMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrumMasterRepository extends JpaRepository<ScrumMaster, Long> {
}
