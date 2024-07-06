package org.example.controller;

import org.example.models.InputDto;
import org.example.service.CourseHandicapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseHandicapController {
    @Autowired
    CourseHandicapService courseHandicapService;

    @GetMapping("/")
    public String showForm() {
        return "input";
    }

    @PostMapping("/calculate")
    public String calculateHandicap(@ModelAttribute() InputDto inputDto, Model model) {
        double courseHandicap = courseHandicapService.count(inputDto);
        model.addAttribute("courseHandicap", courseHandicap);
        return "result";
    }
}
