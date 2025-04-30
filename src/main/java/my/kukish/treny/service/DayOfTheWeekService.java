package my.kukish.treny.service;

import lombok.RequiredArgsConstructor;
import my.kukish.treny.database.repository.DayOfTheWeekRepository;
import my.kukish.treny.dto.DayOfTheWeekDto;
import my.kukish.treny.mapper.DayOfTheWeekMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DayOfTheWeekService {
    private final DayOfTheWeekRepository dayOfTheWeekRepository;
    private final DayOfTheWeekMapper dayOfTheWeekMapper;


    public List<DayOfTheWeekDto> findAll() {
        return dayOfTheWeekRepository.findAll()
                .stream()
                .map(dayOfTheWeekMapper::map)
                .toList();
    }
}
