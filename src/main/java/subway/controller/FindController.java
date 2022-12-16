package subway.controller;

import java.util.Scanner;
import java.util.function.Function;
import subway.command.FindCommand;
import subway.dto.EdgeDto;
import subway.dto.FindResultDto;
import subway.service.SubwayService;
import subway.view.InputView;
import subway.view.OutputView;

public class FindController {
    private final Scanner scanner;
    private final SubwayService subWayService;

    public FindController(Scanner scanner) {
        this.scanner = scanner;
        this.subWayService = new SubwayService();
    }

    public void operate() {
        FindCommand findCommand = repeatRead(InputView::readFindCommand);
        while (!findCommand.isBack()) {
            EdgeDto edgeDto = repeatRead(InputView::readStations);
            OutputView.printResult(subWayService.routeLookup(edgeDto, findCommand));
            findCommand = repeatRead(InputView::readFindCommand);
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
