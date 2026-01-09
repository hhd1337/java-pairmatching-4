package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.dto.CourseLevelMissionDto;

public class PairHistory {
    private List<Pair> pairHistoryList;

    public PairHistory(List<Pair> pairHistoryList) {
        this.pairHistoryList = pairHistoryList;
    }

    public boolean isMatchedInSameLevel(String crew1Name, String crew2Name, Level level) {
        return pairHistoryList.stream()
                .filter(pair -> pair.getLevel().equals(level))
                .anyMatch(pair -> pair.encludesCrews(crew1Name, crew2Name));
    }

    public List<Pair> matchPairs(List<String> crewList, CourseLevelMissionDto dto) {
        if (crewList.size() % 2 == 0) {
            return matchPairsWithEvenCrews(crewList, dto);
        }
        return matchPairsWithOddCrews(crewList, dto);
    }

    //    - 조건) 한번 매칭 시도가 실패할 때 마다 안내 문구를 출력 후 재매칭을 진행한다.
    //    - 조건) 안내문구에서 아니오를 선택할 경우 코스, 레벨, 미션을 다시 선택한다.
    //    - 조건) 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러 메시지를 출력한다.
    public List<Pair> matchPairsWithEvenCrews(List<String> crewList, CourseLevelMissionDto dto) {
        List<String> shuffledCrewList = Randoms.shuffle(crewList);
        List<Pair> tempPairList = new ArrayList<>();

        for (int i = 0; i < shuffledCrewList.size(); i = i + 2) {
            String crew1 = shuffledCrewList.get(i);
            String crew2 = shuffledCrewList.get(i + 1);
            if (isMatchedInSameLevel(crew1, crew2, dto.getLevel())) {
                throw new IllegalArgumentException(crew1 + "과" + crew2 + "는 같은 레벨에서 페어가 된 적이 있습니다.");
            }

            tempPairList.add(new Pair(crew1, crew2, dto.getCourse(), dto.getLevel(), dto.getMission()));
        }

        pairHistoryList.addAll(tempPairList);

        return tempPairList;
    }

    public List<Pair> matchPairsWithOddCrews(List<String> crewList, CourseLevelMissionDto dto) {
        List<String> shuffledCrewList = Randoms.shuffle(crewList);
        List<Pair> tempPairList = new ArrayList<>();

        for (int i = 0; i < shuffledCrewList.size() - 3; i = i + 2) {
            String crew1 = shuffledCrewList.get(i);
            String crew2 = shuffledCrewList.get(i + 1);
            if (isMatchedInSameLevel(crew1, crew2, dto.getLevel())) {
                throw new IllegalArgumentException(crew1 + "과" + crew2 + "는 같은 레벨에서 페어가 된 적이 있습니다.");
            }

            tempPairList.add(new Pair(crew1, crew2, dto.getCourse(), dto.getLevel(), dto.getMission()));
        }

        String crew1 = shuffledCrewList.get(shuffledCrewList.size() - 3);
        String crew2 = shuffledCrewList.get(shuffledCrewList.size() - 2);
        String crew3 = shuffledCrewList.get(shuffledCrewList.size() - 1);
        if (isMatchedInSameLevel(crew1, crew2, dto.getLevel())) {
            throw new IllegalArgumentException(crew1 + "과" + crew2 + "는 같은 레벨에서 페어가 된 적이 있습니다.");
        }
        if (isMatchedInSameLevel(crew2, crew3, dto.getLevel())) {
            throw new IllegalArgumentException(crew2 + "과" + crew3 + "는 같은 레벨에서 페어가 된 적이 있습니다.");
        }
        if (isMatchedInSameLevel(crew3, crew1, dto.getLevel())) {
            throw new IllegalArgumentException(crew3 + "과" + crew1 + "는 같은 레벨에서 페어가 된 적이 있습니다.");
        }

        tempPairList.add(new Pair(crew1, crew2, crew3, dto.getCourse(), dto.getLevel(), dto.getMission()));

        pairHistoryList.addAll(tempPairList);

        return tempPairList;
    }

    // 과정/레벨/미션을 받아 해당 페어매칭 리스트를 반환하는 메소드

    // pairHistoryList 초기화하는 메소드
}
