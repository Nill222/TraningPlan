package my.kukish.treny.mapper;

import my.kukish.treny.database.entity.DayOfTheWeek;
import my.kukish.treny.dto.DayOfTheWeekDto;
import org.springframework.stereotype.Component;


@Component
public class DayOfTheWeekMapper implements Mapper<DayOfTheWeek, DayOfTheWeekDto> {
    @Override
    public DayOfTheWeekDto map(DayOfTheWeek object) {
        return new DayOfTheWeekDto(
                object.getNameOfTheDay()
        );
    }
}
