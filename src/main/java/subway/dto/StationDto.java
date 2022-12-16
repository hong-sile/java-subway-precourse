package subway.dto;

import subway.domain.Station;
import subway.repository.StationRepository;

public class StationDto {
    private final Station station;

    public StationDto(String station) {
        this.station = StationRepository.findByName(station);
    }

    public Station getStation() {
        return station;
    }
}
