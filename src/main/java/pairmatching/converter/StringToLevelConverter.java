package pairmatching.converter;


import pairmatching.domain.Level;

public class StringToLevelConverter implements Converter<String, Level> {
    @Override
    public Level convert(String source) {
        Level level = Level.findBySymbol(source.trim());
        return level;
    }
}