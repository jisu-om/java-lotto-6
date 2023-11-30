package lotto.view;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final String START_MESSAGE = "";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

}
