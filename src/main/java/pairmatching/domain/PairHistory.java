package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
    public List<Pair> findPairMatchingListByCourseLevelMission(CourseLevelMissionDto dto) {
        return pairHistoryList.stream()
                .filter(pair -> pair.getCourse().equals(dto.getCourse()))
                .filter(pair -> pair.getLevel().equals(dto.getLevel()))
                .filter(pair -> pair.getLevel().equals(dto.getLevel()))
                .collect(Collectors.toList());
    }

    // pairHistoryList 초기화하는 메소드
}
