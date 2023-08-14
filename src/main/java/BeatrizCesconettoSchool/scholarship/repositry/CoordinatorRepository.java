package BeatrizCesconettoSchool.scholarship.repositry;

import BeatrizCesconettoSchool.scholarship.entity.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordinatorRepository extends JpaRepository <Coordinator, Long> {

Optional<Coordinator> findById(Long id);

}
