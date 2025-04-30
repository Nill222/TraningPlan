package my.kukish.treny.http.controllers;

import lombok.RequiredArgsConstructor;
import my.kukish.treny.dto.ExerciseDto;
import my.kukish.treny.dto.TrainingWeekCreateEditDto;
import my.kukish.treny.dto.TrainingWeekReadDto;
import my.kukish.treny.service.DayOfTheWeekService;
import my.kukish.treny.service.ExerciseService;
import my.kukish.treny.service.TrainingWeekService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/trainingWeek")
@RequiredArgsConstructor
public class TrainingWeekController {
    private final TrainingWeekService trainingWeekService;
    private final ExerciseService exerciseService;
    private final DayOfTheWeekService dayOfTheWeekService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("trainingWeekList", trainingWeekService.findAll());
        model.addAttribute("exercises", exerciseService.findAll());
        model.addAttribute("dayOfTheWeek", dayOfTheWeekService.findAll());
        return "trainingWeek";
    }

    @PostMapping("/exercise")
    public String create(@ModelAttribute ExerciseDto exerciseDto){
        exerciseService.create(exerciseDto);
        return "redirect:/trainingWeek";
    }

    @PostMapping("/find")
    public String findById(Model model, @RequestParam("id") Integer id) {
        return trainingWeekService.findById(id)
                .map(trainingWeek -> {
                    model.addAttribute("trainingWeek", trainingWeek);
                    return "trainingWeek";  // отображение информации о найденной неделе
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Тренировочная неделя не найдена"));
    }

    @PostMapping
    public String create(@ModelAttribute TrainingWeekCreateEditDto trainingWeekCreateEditDto) {
        trainingWeekService.create(trainingWeekCreateEditDto);
        return "redirect:/trainingWeek";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        Optional<TrainingWeekReadDto> trainingWeekOptional = trainingWeekService.findById(id);
        if (trainingWeekOptional.isPresent()) {
            model.addAttribute("trainingWeek", trainingWeekOptional.get());
        } else {
            return "redirect:/trainingWeek";
        }
        model.addAttribute("exercises", exerciseService.findAll());
        model.addAttribute("dayOfTheWeek", dayOfTheWeekService.findAll());
        return "update";
    }

    @PostMapping("/{id}")
    public String update(Model model, @PathVariable int id, @ModelAttribute TrainingWeekCreateEditDto trainingWeekCreateEditDto) {
        return trainingWeekService.update(id, trainingWeekCreateEditDto)
                .map(trainingWeekReadDto  -> {
                    model.addAttribute("trainingWeek", trainingWeekReadDto );
                    return "trainingWeek";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        if (!trainingWeekService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Тренировочная неделя не найдена");
        }
        return "redirect:/trainingWeek";
    }
}
