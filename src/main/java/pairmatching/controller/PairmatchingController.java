package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Menu;
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
        List<String> backs = fileReader.readBackEndCrews();
        List<String> fronts = fileReader.readFrontEndCrews();

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
