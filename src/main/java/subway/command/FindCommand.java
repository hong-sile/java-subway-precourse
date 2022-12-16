package subway.command;

public enum FindCommand {
    SHORTEST_DISTANCE("1", "최단 거리"),
    SMALLEST_TIME("2", "최소 시간"),
    BACK("B", "돌아가기");

    private static final String INVALID_VALUE_MESSAGE = "1, 2, B 중에 입력해주십시오.";
    private final String code;
    private final String description;

    FindCommand(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static FindCommand from(String code) {
        for (FindCommand command : FindCommand.values()) {
            if (command.code.equals(code)) {
                return command;
            }
        }
        throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
    }

    public boolean isShortestDistance() {
        return this == SHORTEST_DISTANCE;
    }

    public boolean isSmallestTime() {
        return this == SMALLEST_TIME;
    }

    public boolean isBack() {
        return this== BACK;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
