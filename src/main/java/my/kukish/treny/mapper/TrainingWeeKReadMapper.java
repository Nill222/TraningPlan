package my.kukish.treny.mapper;

import lombok.RequiredArgsConstructor;
import my.kukish.treny.database.entity.TrainingWeek;
import my.kukish.treny.dto.DayOfTheWeekDto;
import my.kukish.treny.dto.ExerciseDto;
import my.kukish.treny.dto.TrainingWeekReadDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TrainingWeeKReadMapper implements Mapper<TrainingWeek, TrainingWeekReadDto> {
    private final ExerciseReadMapper exerciseReadMapper;
    private final DayOfTheWeekMapper dayOfTheWeekMapper;

    @Override
    public TrainingWeekReadDto map(TrainingWeek object) {
        ExerciseDto exercise = Optional.ofNullable(object.getExercise())
                .map(exerciseReadMapper::map)
                .orElse(null);
        DayOfTheWeekDto day = Optional.ofNullable(object.getDay())
                .map(dayOfTheWeekMapper::map)
                .orElse(null);
        return new TrainingWeekReadDto(
                object.getId(),
                object.getWeekNum(),
                object.getRepetitions(),
                object.getNumberOfApproaches(),
                exercise,
                day
        );
    }
}
