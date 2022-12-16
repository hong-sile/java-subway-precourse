package subway.command;

public enum MainCommand {
    FIND_ROUTE("1", "경로 조회"),
    QUIT("Q", "종료");

    private static final String INVALID_VALUE_MESSAGE = "1, Q 중에 입력해주십시오.";
    private final String code;
    private final String description;

    MainCommand(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static MainCommand from(String code) {
        for (MainCommand command : MainCommand.values()) {
            if (command.code.equals(code)) {
                return command;
            }
        }
        throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
    }

    public boolean isFindRouteCode() {
        return this == FIND_ROUTE;
    }

    public boolean isQuitCode() {
        return this == QUIT;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
