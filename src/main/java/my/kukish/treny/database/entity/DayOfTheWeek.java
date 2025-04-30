package my.kukish.treny.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "day_of_the_week")
public class DayOfTheWeek {
    @Id
    @Column(name = "name_of_the_day")
    private String nameOfTheDay;
}
