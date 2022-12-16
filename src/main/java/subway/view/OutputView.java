package subway.view;

import subway.command.FindCommand;
import subway.command.MainCommand;
import subway.dto.FindResultDto;
import subway.dto.StationDto;

public class OutputView {
    private static final String DESCRIPTION_PREFIX = "## ";
    private static final String MAIN_SCREEN_MESSAGE = "메인 화면";
    private static final String FIND_SCREEN_MESSAGE = "경로 기준";
    private static final String FIND_RESULT_MESSAGE = "조회 결과";
    private static final String SELECT_COMMAND_MESSAGE = "원하는 기능을 선택하세요";
    private static final String TOTAL_DISTANCE_MESSAGE = "총 거리: ";
    private static final String TOTAL_TIME_MESSAGE = "총 소요 시간: ";
    private static final String DISTANCE_UNIT = "km";
    private static final String TIME_UNIT = "분";
    private static final String DOT = ". ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String CONTOUR = "---";

    public static void printException(Exception e) {
        System.out.print(ERROR_PREFIX);
        System.out.println(e.getMessage());
    }

    public static void printMainScreen() {
        System.out.println(DESCRIPTION_PREFIX + MAIN_SCREEN_MESSAGE);
        for (MainCommand mainCommand : MainCommand.values()) {
            System.out.println(mainCommand.getCode() + DOT + mainCommand.getDescription());
        }
        printReadCommandMessage();
    }

    private static void printReadCommandMessage() {
        System.out.println(DESCRIPTION_PREFIX + SELECT_COMMAND_MESSAGE);
    }

    public static void printFindScreen() {
        System.out.println(DESCRIPTION_PREFIX + FIND_SCREEN_MESSAGE);
        for (FindCommand findCommand : FindCommand.values()) {
            System.out.println(findCommand.getCode() + DOT + findCommand.getDescription());
        }
        printReadCommandMessage();
    }

    public static void printResult(FindResultDto findResultDto) {
        System.out.println(DESCRIPTION_PREFIX + FIND_RESULT_MESSAGE);
        System.out.println(INFO_PREFIX + CONTOUR);
        System.out.println(INFO_PREFIX + TOTAL_DISTANCE_MESSAGE + findResultDto.getDistance() + DISTANCE_UNIT);
        System.out.println(INFO_PREFIX + TOTAL_TIME_MESSAGE + findResultDto.getTime() + TIME_UNIT);
        System.out.println(INFO_PREFIX + CONTOUR);
        for (StationDto station : findResultDto.getVertexes()) {
            System.out.print(INFO_PREFIX);
            System.out.println(station.getStation().getName());
        }
    }
}
