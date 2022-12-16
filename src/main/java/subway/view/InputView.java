package subway.view;

import java.util.Scanner;
import subway.command.FindCommand;
import subway.command.MainCommand;
import subway.dto.EdgeDto;
import subway.dto.StationDto;

public class InputView {

    public static MainCommand readMainCommand(Scanner scanner) {
        String code = scanner.nextLine();
        return MainCommand.from(code);
    }

    public static FindCommand readFindCommand(Scanner scanner) {
        String code = scanner.nextLine();
        return FindCommand.from(code);
    }

    public static EdgeDto readStations(Scanner scanner) {
        StationDto startSource = readStation(scanner);
        StationDto destination = readStation(scanner);
        return new EdgeDto(startSource, destination);
    }

    private static StationDto readStation(Scanner scanner) {
        String station = scanner.nextLine();
        return new StationDto(station);
    }
}
