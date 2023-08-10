package BeatrizCesconettoSchool.scholarship.repositry;

import BeatrizCesconettoSchool.scholarship.entity.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends JpaRepository <Squad,Long> {
}
