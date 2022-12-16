package subway.view;

import java.util.Scanner;
import subway.command.FindCommand;
import subway.command.MainCommand;

public class InputView {

    public static MainCommand readMainCommand(Scanner scanner) {
        String code = scanner.nextLine();
        return MainCommand.from(code);
    }

}
