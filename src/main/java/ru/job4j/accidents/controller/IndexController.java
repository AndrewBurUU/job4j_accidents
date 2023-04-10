package ru.job4j.accidents.controller;

import org.springframework.security.core.context.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accidents.repository.*;

@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        return "index";
    }
}
