package my.kukish.treny.service;

import lombok.RequiredArgsConstructor;
import my.kukish.treny.database.repository.TrainingWeekRepository;
import my.kukish.treny.dto.TrainingWeekCreateEditDto;
import my.kukish.treny.dto.TrainingWeekReadDto;
import my.kukish.treny.mapper.TrainingWeeKReadMapper;
import my.kukish.treny.mapper.TrainingWeekCreateEditMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TrainingWeekService {
    private final TrainingWeekRepository trainingWeekRepository;
    private final TrainingWeeKReadMapper trainingWeeKReadMapper;
    private final TrainingWeekCreateEditMapper trainingWeekCreateEditMapper;

    public List<TrainingWeekReadDto> findAll() {
        return trainingWeekRepository.findAll()
                .stream()
                .map(trainingWeeKReadMapper::map)
                .toList();
    }

    public Optional<TrainingWeekReadDto> findById(Integer id) {
        return trainingWeekRepository.findById(id)
                .map(trainingWeeKReadMapper::map);
    }

    @Transactional
    public TrainingWeekReadDto create(TrainingWeekCreateEditDto trainingWeekCreateEditDto) {
        return Optional.of(trainingWeekCreateEditDto)
                .map(trainingWeekCreateEditMapper::map)
                .map(trainingWeekRepository::save)
                .map(trainingWeeKReadMapper::map)
                .orElse(null);
    }

    @Transactional
    public Optional<TrainingWeekReadDto> update(Integer id, TrainingWeekCreateEditDto trainingWeekCreateEditDto) {
        return trainingWeekRepository.findById(id)
                .map(entity -> trainingWeekCreateEditMapper.map(trainingWeekCreateEditDto, entity))
                .map(trainingWeekRepository::saveAndFlush)
                .map(trainingWeeKReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return trainingWeekRepository.findById(id)
                .map(entity -> {
                    trainingWeekRepository.delete(entity);
                    trainingWeekRepository.flush();
                    return true;
                }).orElse(false);
    }
}
