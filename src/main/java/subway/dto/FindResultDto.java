package subway.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Station;

public class FindResultDto {
    private final int time;
    private final int distance;
    private final List<StationDto> vertexes;

    public FindResultDto(int time, int distance, List<Station> vertexes) {
        this.time = time;
        this.distance = distance;
        this.vertexes = vertexes
                .stream()
                .map(Station::toDto)
                .collect(Collectors.toList());
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public List<StationDto> getVertexes() {
        return Collections.unmodifiableList(vertexes);
    }
}
