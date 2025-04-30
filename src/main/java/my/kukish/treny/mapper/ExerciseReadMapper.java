package my.kukish.treny.mapper;

import my.kukish.treny.database.entity.Exercise;
import my.kukish.treny.dto.ExerciseDto;
import org.springframework.stereotype.Component;

@Component
public class ExerciseReadMapper implements Mapper<Exercise, ExerciseDto>{
    @Override
    public ExerciseDto map(Exercise object) {
        return new ExerciseDto(
                object.getName()
        );
    }
}
