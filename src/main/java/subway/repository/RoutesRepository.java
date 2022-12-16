package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.Routes;

public class RoutesRepository {
    private static final List<Routes> routes = new ArrayList<>();

    public static List<Routes> routes() {
        return Collections.unmodifiableList(routes);
    }

    public static void addRoutes(Routes line) {
        routes.add(line);
    }

    public static void deleteAll() {
        routes.clear();
    }
}
