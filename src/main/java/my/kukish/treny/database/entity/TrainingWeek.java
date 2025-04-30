package my.kukish.treny.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "training_week")
public class TrainingWeek implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "week_number")
    private int weekNum;

    private String repetitions;

    @Column(name = "number_of_approaches")
    private Integer numberOfApproaches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name", nullable = false)
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day", referencedColumnName = "name_of_the_day", nullable = false)
    private DayOfTheWeek day;
}
