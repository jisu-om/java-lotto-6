package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = MainController.create();
        mainController.run();
        Console.close();
    }
}
