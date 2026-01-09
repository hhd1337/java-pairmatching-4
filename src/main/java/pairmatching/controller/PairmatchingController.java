package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Menu;
import pairmatching.domain.Pair;
import pairmatching.domain.PairHistory;
import pairmatching.dto.CourseLevelMissionDto;
import pairmatching.io.FileReader;
import pairmatching.view.OutputView;

public class PairmatchingController {

    private final InputHandler inputHandler;
    private final OutputView outputView;

    public PairmatchingController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void process() {
        FileReader fileReader = new FileReader();
        List<String> backCrews = fileReader.readBackEndCrews();
        List<String> frontCrews = fileReader.readFrontEndCrews();
        PairHistory pairHistory = new PairHistory(new ArrayList<>());

        Menu menu;
        do {
            outputView.printHelloAndMenu();
            menu = inputHandler.inputMenu();
            run(menu, backCrews, frontCrews, pairHistory);
        } while (menu != Menu.QUIT);
    }

    private void run(Menu menu, List<String> backCrews, List<String> frontCrews, PairHistory pairHistory) {
        if (menu == Menu.PAIR_MATCH) {
            runPairMatch(backCrews, frontCrews, pairHistory);
        }
        if (menu == Menu.PAIR_CHECK) {
            // runPairCheck();
        }
        if (menu == Menu.PAIR_RESET) {
            // runPairReset();
        }
    }

    private void runPairMatch(List<String> backCrews, List<String> frontCrews, PairHistory pairHistory) {
        outputView.printCourseLevelMission();
        outputView.printCourseLevelMissionInputPrompt();
        CourseLevelMissionDto dto = inputHandler.inputCourseLevelMission();

        List<Pair> pairsInThisMission = matchPairsThreeTimes(backCrews, frontCrews, pairHistory, dto);

        outputView.printPairMatchResult(pairsInThisMission);

    }

    private List<Pair> matchPairsThreeTimes(List<String> backCrews, List<String> frontCrews, PairHistory pairHistory,
                                            CourseLevelMissionDto dto) {
        int tryCount = 0;
        while (tryCount < 3) {
            try {
                if (dto.getCourse().equals(Course.BACK_END)) {
                    return pairHistory.matchPairs(backCrews, dto);
                }
                if (dto.getCourse().equals(Course.FRONT_END)) {
                    return pairHistory.matchPairs(frontCrews, dto);
                }
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
                tryCount++;
            }
        }
        outputView.printErrorMessage(new IllegalArgumentException("3회 시도를 하였으나 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없습니다."));
        return null;
    }

}
