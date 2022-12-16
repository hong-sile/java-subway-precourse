package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import subway.domain.Station;

public class StationRepository {
    private static final String INVALID_VALUE_MESSAGE = "존재하지 않는 역입니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station findByName(String name) {
        Optional<Station> station = stations()
                .stream()
                .filter(st -> st.isName(name))
                .findAny();
        if (station.isEmpty()) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
        return station.get();
    }
}
