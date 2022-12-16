package subway.dto;

public class LineWeightDto {
    private final int time;
    private final int distance;

    public LineWeightDto(int time, int distance) {
        this.time = time;
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
