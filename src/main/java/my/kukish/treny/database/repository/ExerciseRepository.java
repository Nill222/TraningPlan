package my.kukish.treny.database.repository;

import my.kukish.treny.database.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
}
