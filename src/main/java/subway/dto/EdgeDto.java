package subway.dto;

public class EdgeDto {
    private final StationDto startSource;
    private final StationDto destinationSource;

    public EdgeDto(StationDto startSource, StationDto destinationSource) {
        this.startSource = startSource;
        this.destinationSource = destinationSource;
    }

    public StationDto getStartSource() {
        return startSource;
    }

    public StationDto getDestinationSource() {
        return destinationSource;
    }
}
