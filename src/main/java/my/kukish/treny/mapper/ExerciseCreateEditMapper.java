package my.kukish.treny.mapper;

import my.kukish.treny.database.entity.Exercise;
import my.kukish.treny.dto.ExerciseDto;
import org.springframework.stereotype.Component;

@Component
public class ExerciseCreateEditMapper implements Mapper<ExerciseDto, Exercise> {
    @Override
    public Exercise map(ExerciseDto object) {
        Exercise exercise = new Exercise();
        copy(object, exercise);
        return exercise;
    }
    private void copy(ExerciseDto object, Exercise exercise) {
        exercise.setName(object.getNameOfExercise());
    }

    @Override
    public Exercise map(ExerciseDto fromObject, Exercise toObject) {
        copy(fromObject, toObject);
        return toObject;
    }
}
