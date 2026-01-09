package pairmatching;

import pairmatching.controller.PairmatchingController;

public class Application {
    public static void main(String[] args) {
        PairmatchingConfig pairmatchingConfig = new PairmatchingConfig();
        PairmatchingController pairmatchingController = pairmatchingConfig.pairmatchingController();
        pairmatchingController.process();
    }
}
