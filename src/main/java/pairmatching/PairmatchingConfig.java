package pairmatching;

import pairmatching.controller.InputHandler;
import pairmatching.controller.IteratorInputTemplate;
import pairmatching.controller.PairmatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingConfig {

    private InputView inputView;
    private OutputView outputView;
    private IteratorInputTemplate iteratorInputTemplate;
    private InputHandler inputHandler;
    private PairmatchingController pairmatchingController;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public IteratorInputTemplate iteratorInputTemplate() {
        if (iteratorInputTemplate == null) {
            iteratorInputTemplate = new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public InputHandler iteratorInputHandler() {
        if (inputHandler == null) {
            inputHandler = new InputHandler(inputView(), iteratorInputTemplate());
        }
        return inputHandler;
    }

    public PairmatchingController pairmatchingController() {
        if (pairmatchingController == null) {
            pairmatchingController = new PairmatchingController(iteratorInputHandler(), outputView());
        }
        return pairmatchingController;
    }
}
