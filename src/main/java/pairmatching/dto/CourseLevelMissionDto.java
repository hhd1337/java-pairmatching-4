package pairmatching.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class CourseLevelMissionDto {
    private Course course;
    private Level level;
    private Mission mission;

    public CourseLevelMissionDto(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }
}
