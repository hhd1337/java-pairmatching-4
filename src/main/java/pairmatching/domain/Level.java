package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    ONE("레벨1"),
    TWO("레벨2"),
    THREE("레벨3"),
    FOUR("레벨4"),
    FIVE("레벨5");

    private final String symbol;

    Level(String symbol) {
        this.symbol = symbol;
    }

    public static Level findBySymbol(String symbol) {
        return Arrays.stream(Level.values())
                .filter(level -> level.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("레벨을 잘못 입력하였습니다."));
    }

    public String getSymbol() {
        return this.symbol;
    }
}
