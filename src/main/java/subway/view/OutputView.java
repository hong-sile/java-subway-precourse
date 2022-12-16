package subway.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void printException(Exception e) {
        System.out.print(ERROR_PREFIX);
        System.out.println(e.getMessage());
    }
}
