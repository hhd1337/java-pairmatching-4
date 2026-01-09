package pairmatching.domain;

import java.util.Arrays;

public enum Menu {
    PAIR_MATCH("1"),
    PAIR_CHECK("2"),
    PAIR_RESET("3"),
    QUIT("Q");

    private final String symbol;

    Menu(String symbol) {
        this.symbol = symbol;
    }

    public static Menu findBySymbol(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 형식을 입력하였습니다."));
    }

    public String getSymbol() {
        return this.symbol;
    }
}
