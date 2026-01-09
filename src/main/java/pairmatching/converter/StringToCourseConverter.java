package pairmatching.converter;


import pairmatching.domain.Course;

public class StringToCourseConverter implements Converter<String, Course> {
    @Override
    public Course convert(String source) {
        Course course = Course.findBySymbol(source.trim());
        return course;
    }
}