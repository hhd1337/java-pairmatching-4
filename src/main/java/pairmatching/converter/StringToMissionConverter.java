package pairmatching.converter;


import pairmatching.domain.Mission;

public class StringToMissionConverter implements Converter<String, Mission> {
    @Override
    public Mission convert(String source) {
        Mission mission = Mission.findByMissionKor(source.trim());
        return mission;
    }
}