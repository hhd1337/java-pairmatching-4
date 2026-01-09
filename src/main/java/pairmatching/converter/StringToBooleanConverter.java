package pairmatching.converter;


public class StringToBooleanConverter implements Converter<String, Boolean> {
    private static final String YES_KOR = "네";
    private static final String NO_KOR = "아니오";

    @Override
    public Boolean convert(String source) {
        if (source.equals(YES_KOR)) {
            return true;
        }
        if (source.equals(NO_KOR)) {
            return false;
        }
        throw new IllegalArgumentException(YES_KOR + " 또는 " + NO_KOR + "로만 입력해주세요.");
    }
}