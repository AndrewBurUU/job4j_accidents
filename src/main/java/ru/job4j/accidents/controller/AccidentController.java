package ru.job4j.accidents.controller;

import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accidents.service.*;

@Controller
@RequestMapping("/accidents")
@AllArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "accidents/all";
    }
}
