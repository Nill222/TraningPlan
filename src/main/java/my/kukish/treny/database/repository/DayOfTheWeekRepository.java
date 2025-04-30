package my.kukish.treny.database.repository;

import my.kukish.treny.database.entity.DayOfTheWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfTheWeekRepository extends JpaRepository<DayOfTheWeek, String> {
}
