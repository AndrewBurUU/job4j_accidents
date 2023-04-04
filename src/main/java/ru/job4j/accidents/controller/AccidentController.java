package ru.job4j.accidents.controller;

import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accidents.service.*;
import ru.job4j.accidents.model.*;

import javax.servlet.http.*;
import java.util.*;

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

    @GetMapping("/createAccident")
    public String viewCreateAccident(Model model) {
        model.addAttribute("types", accidentService.getAccidentTypes());
        model.addAttribute("rules", accidentService.getRules());
        return "accidents/createAccident";
    }

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        accident.setRules(accidentService.makeRules(req.getParameterValues("rIds")));
        accidentService.save(accident);
        return "redirect:/accidents/all";
    }

    @GetMapping("/formUpdateAccident")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", accidentService.getAccidentTypes());
        model.addAttribute("accident", accidentService.findById(id).get());
        model.addAttribute("rules", accidentService.getRules());
        return "accidents/editAccident";
    }

    @PostMapping("/updateAccident")
    public String update(@ModelAttribute Accident accident, Model model) {
        accidentService.update(accident);
        return "redirect:/accidents/all";
    }

}
