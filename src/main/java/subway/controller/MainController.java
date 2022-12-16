package subway.controller;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import subway.command.MainCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private final Scanner scanner;
    private final FindController findController;

    public MainController(Scanner scanner) {
        this.scanner = scanner;
        this.findController = new FindController(scanner);
    }

    public void run() {
        MainCommand mainCommand = repeatRead(InputView::readMainCommand);
        while (!mainCommand.isQuitCode()) {
            findController.operate();
        }
    }

    public <T> T repeatRead(Function<Scanner, T> reader) {
        try {
            return reader.apply(scanner);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return repeatRead(reader);
        }
    }
}
