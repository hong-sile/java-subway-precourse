package subway.command;

public enum MainCommand {
    FIND_ROUTE("1"),
    QUIT("Q");

    private static final String INVALID_VALUE_MESSAGE = "1, Q 중에 입력해주십시오.";
    private final String code;

    MainCommand(String code) {
        this.code = code;
    }

    public static MainCommand from(String code) {
        for (MainCommand command : MainCommand.values()) {
            if (command.code.equals(code)) {
                return command;
            }
        }
        throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
    }

    public boolean isFindRouteCode(){
        return this == FIND_ROUTE;
    }

    public boolean isQuitCode(){
        return this == QUIT;
    }
}
