package org.example.service;

import org.example.models.InputDto;
import org.springframework.stereotype.Service;

@Service
public class CourseHandicapService {
    private static final int amountCourseRating = 113;

    public double count(InputDto inputDto) {
        return  (inputDto.getHandicapIndex() *
                (inputDto.getSlopeRating() / amountCourseRating))
                + (inputDto.getCourseRating() - inputDto.getPar());
    }
}
