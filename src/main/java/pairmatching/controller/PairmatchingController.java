package pairmatching.controller;

import pairmatching.domain.Menu;
import pairmatching.view.OutputView;

public class PairmatchingController {

    private final InputHandler inputHandler;
    private final OutputView outputView;

    public PairmatchingController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void process() {
        Menu menu;
        do {
            outputView.printHelloAndMenu();
            menu = inputHandler.inputMenu();
            run(menu);
        } while (menu != Menu.QUIT);
    }

    private void run(Menu menu) {
        if (menu == Menu.PAIR_MATCH) {
            // runPairMatch();
        }
        if (menu == Menu.PAIR_CHECK) {
            // runPairCheck();
        }
        if (menu == Menu.PAIR_RESET) {
            // runPairReset();
        }
    }

}
