package my.kukish.treny.mapper;

import lombok.RequiredArgsConstructor;
import my.kukish.treny.database.entity.DayOfTheWeek;
import my.kukish.treny.database.entity.Exercise;
import my.kukish.treny.database.entity.TrainingWeek;
import my.kukish.treny.database.repository.DayOfTheWeekRepository;
import my.kukish.treny.database.repository.ExerciseRepository;
import my.kukish.treny.dto.TrainingWeekCreateEditDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TrainingWeekCreateEditMapper implements Mapper<TrainingWeekCreateEditDto, TrainingWeek> {
    private final ExerciseRepository exerciseRepository;
    private final DayOfTheWeekRepository dayOfTheWeekRepository;

    @Override
    public TrainingWeek map(TrainingWeekCreateEditDto object) {
        TrainingWeek trainingWeek = new TrainingWeek();
        copy(object, trainingWeek);
        return trainingWeek;
    }

    private void copy(TrainingWeekCreateEditDto object, TrainingWeek target) {
        target.setWeekNum(object.getWeekNum());
        target.setRepetitions(object.getRepetitions());
        target.setNumberOfApproaches(object.getNumberOfApproaches());
        target.setExercise(getExercise(object.getName()));
        target.setDay(getDayOfTheWeek(object.getDay()));
    }

    @Override
    public TrainingWeek map(TrainingWeekCreateEditDto fromObject, TrainingWeek toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private Exercise getExercise(String name) {
        return Optional.ofNullable(name)
                .flatMap(exerciseRepository::findById)
                .orElse(null);
    }

    private DayOfTheWeek getDayOfTheWeek(String day) {
        return Optional.ofNullable(day)
                .flatMap(dayOfTheWeekRepository::findById)
                .orElse(null);
    }
}
