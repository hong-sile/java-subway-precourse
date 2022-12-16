package subway.view;

import subway.command.FindCommand;
import subway.command.MainCommand;

public class OutputView {
    private static final String DESCRIPTION_PREFIX = "## ";
    private static final String MAIN_SCREEN_MESSAGE = "메인 화면";
    private static final String FIND_SCREEN_MESSAGE = "경로 기준";
    private static final String SELECT_COMMAND_MESSAGE = "원하는 기능을 선택하세요";
    private static final String DOT = ". ";
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void printException(Exception e) {
        System.out.print(ERROR_PREFIX);
        System.out.println(e.getMessage());
    }

    public static void printMainScreen() {
        System.out.print(DESCRIPTION_PREFIX);
        System.out.println(MAIN_SCREEN_MESSAGE);
        for (MainCommand mainCommand : MainCommand.values()) {
            System.out.println(mainCommand.getCode() + DOT + mainCommand.getDescription());
        }
        printReadCommandMessage();
    }

    private static void printReadCommandMessage() {
        System.out.print(DESCRIPTION_PREFIX);
        System.out.println(SELECT_COMMAND_MESSAGE);
    }

    public static void printFindScreen() {
        System.out.print(DESCRIPTION_PREFIX);
        System.out.println(FIND_SCREEN_MESSAGE);
        for (FindCommand findCommand : FindCommand.values()) {
            System.out.println(findCommand.getCode() + DOT + findCommand.getDescription());
        }
        printReadCommandMessage();
    }
}
