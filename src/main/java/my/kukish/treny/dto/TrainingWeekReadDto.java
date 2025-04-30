package my.kukish.treny.dto;

import lombok.Value;

@Value
public class TrainingWeekReadDto {
    Integer id;
    int weekNum;
    String repetitions;
    Integer numberOfApproaches;
    ExerciseDto exercise;
    DayOfTheWeekDto day;
}
