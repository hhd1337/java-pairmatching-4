package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACK_END("백엔드"),
    FRONT_END("프론트엔드");

    private final String symbol;

    Course(String symbol) {
        this.symbol = symbol;
    }

    public static Course findBySymbol(String symbol) {
        return Arrays.stream(Course.values())
                .filter(course -> course.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("과정을 잘못 입력하였습니다."));
    }

    public String getSymbol() {
        return this.symbol;
    }
}
