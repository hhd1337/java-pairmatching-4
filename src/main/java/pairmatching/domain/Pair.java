package pairmatching.domain;

import java.util.List;

public class Pair {
    private String crew1Name;
    private String crew2Name;
    private String crew3Name;

    private Course course;
    private Level level;
    private Mission mission;

    // 2명 pair 생성
    public Pair(String crew1Name, String crew2Name, Course course, Level level, Mission mission) {
        this.crew1Name = crew1Name;
        this.crew2Name = crew2Name;
        this.crew3Name = null;
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    // 3명 pair 생성
    public Pair(String crew1Name, String crew2Name, String crew3Name, Course course, Level level, Mission mission) {
        this.crew1Name = crew1Name;
        this.crew2Name = crew2Name;
        this.crew3Name = crew3Name;
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public boolean encludesCrews(String crew1Name, String crew2Name) {
        List<String> crewsInPair = List.of(this.crew1Name, this.crew2Name, this.crew3Name);
        return crewsInPair.contains(crew1Name) && crewsInPair.contains(crew2Name);
    }

    public String getCrew1Name() {
        return crew1Name;
    }

    public String getCrew2Name() {
        return crew2Name;
    }

    public String getCrew3Name() {
        return crew3Name;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
