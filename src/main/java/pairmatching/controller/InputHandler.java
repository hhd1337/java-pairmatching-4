package pairmatching.controller;

import java.util.List;
import pairmatching.converter.StringToCourseConverter;
import pairmatching.converter.StringToLevelConverter;
import pairmatching.converter.StringToMenuConverter;
import pairmatching.converter.StringToMissionConverter;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Menu;
import pairmatching.domain.Mission;
import pairmatching.dto.CourseLevelMissionDto;
import pairmatching.util.DelimiterParser;
import pairmatching.view.InputView;

public class InputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate inputTemplate;

    public InputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.inputTemplate = iteratorInputTemplate;
    }

    public Menu inputMenu() {
        StringToMenuConverter converter = new StringToMenuConverter();
        return inputTemplate.execute(
                inputView::inputMenu,
                value -> {
                    value = value.trim();

                    return converter.convert(value);
                }
        );
    }

    public CourseLevelMissionDto inputCourseLevelMission() {
        DelimiterParser parser = new DelimiterParser();
        StringToCourseConverter courseConverter = new StringToCourseConverter();
        StringToMissionConverter missionConverter = new StringToMissionConverter();
        StringToLevelConverter levelConverter = new StringToLevelConverter();
        return inputTemplate.execute(
                inputView::inputCourseLevelMission,
                value -> {
                    value = value.trim();

                    List<String> parsedParts = parser.parse(value);
                    Course course = courseConverter.convert(parsedParts.get(0));
                    Level level = levelConverter.convert(parsedParts.get(1));
                    Mission mission = missionConverter.convert(parsedParts.get(2));

                    return new CourseLevelMissionDto(course, level, mission);
                }
        );
    }
}