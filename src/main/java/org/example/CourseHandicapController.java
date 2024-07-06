package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseHandicapController {
    private static final int amountCourseRating = 113;

    @GetMapping("/")
    public String showForm() {
        return "input";
    }

    @PostMapping("/calculate")
    public String calculateHandicap(@RequestParam("handicapIndex") double handicapIndex,
                                    @RequestParam("slopeRating") double slopeRating,
                                    @RequestParam("courseRating") double courseRating,
                                    @RequestParam("par") double par,
                                    Model model) {
        double courseHandicap = (handicapIndex * (slopeRating / 113)) + (courseRating - par);
        model.addAttribute("courseHandicap", courseHandicap);
        return "result";
    }
}
