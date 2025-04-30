package my.kukish.treny.service;

import lombok.RequiredArgsConstructor;
import my.kukish.treny.database.repository.ExerciseRepository;
import my.kukish.treny.dto.ExerciseDto;
import my.kukish.treny.mapper.ExerciseCreateEditMapper;
import my.kukish.treny.mapper.ExerciseReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseReadMapper exerciseReadMapper;
    private final ExerciseCreateEditMapper exerciseCreateEditMapper;

    public List<ExerciseDto> findAll() {
        return exerciseRepository.findAll()
                .stream()
                .map(exerciseReadMapper::map)
                .toList();
    }

    public Optional<ExerciseDto> findById(String id) {
        return exerciseRepository.findById(id)
                .map(exerciseReadMapper::map);
    }

    @Transactional
    public ExerciseDto create(ExerciseDto exerciseCreateEditDto) {
        return Optional.of(exerciseCreateEditDto)
                .map(exerciseCreateEditMapper::map)
                .map(exerciseRepository::save)
                .map(exerciseReadMapper::map)
                .orElse(null);
    }

    @Transactional
    public Optional<ExerciseDto> update(String id, ExerciseDto exerciseCreateEditDto) {
        return exerciseRepository.findById(id)
                .map(entity -> exerciseCreateEditMapper.map(exerciseCreateEditDto, entity))
                .map(exerciseRepository::saveAndFlush)
                .map(exerciseReadMapper::map);
    }

    @Transactional
    public boolean delete(String id) {
        return exerciseRepository.findById(id)
                .map(entity -> {
                    exerciseRepository.delete(entity);
                    exerciseRepository.flush();
                    return true;
                }).orElse(false);
    }
}
