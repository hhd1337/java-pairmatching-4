package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
    CAR_RACE(Level.ONE, "자동차경주"),
    LOTTO(Level.ONE, "로또"),
    BASEBALL(Level.ONE, "숫자야구게임"),
    SHOPPING_CART(Level.TWO, "장바구니"),
    PAY(Level.TWO, "결제"),
    SUBWAY(Level.TWO, "지하철노선도"),
    PERFORMANCE_IMPROVE(Level.FOUR, "성능개선"),
    DISTRIBUTION(Level.FOUR, "배포");

    private final Level level;
    private final String missionKor;

    Mission(Level level, String missionKor) {
        this.level = level;
        this.missionKor = missionKor;
    }

    public static Mission findByMissionKor(String value) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.missionKor.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("미션을 잘못 입력하였습니다."));
    }

    public Level getLevel() {
        return this.level;
    }

    public String getMissionKor() {
        return missionKor;
    }


}
