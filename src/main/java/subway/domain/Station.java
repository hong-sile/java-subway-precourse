package subway.domain;

import subway.dto.StationDto;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public StationDto toDto() {
        return new StationDto(this);
    }
}
