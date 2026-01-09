package pairmatching.controller;

import pairmatching.converter.StringToMenuConverter;
import pairmatching.domain.Menu;
import pairmatching.view.InputView;

public class InputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate inputTemplate;

    public InputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.inputTemplate = iteratorInputTemplate;
    }

    public Menu inputMenu() {
        StringToMenuConverter converter = new StringToMenuConverter();
        return inputTemplate.execute(
                inputView::inputMenu,
                value -> {
                    value = value.trim();

                    return converter.convert(value);
                }
        );
    }
}