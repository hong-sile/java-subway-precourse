package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;

public class LineWeightEdge extends DefaultWeightedEdge {
    private final int time;
    private final int distance;
    private boolean isWeightTime;

    public LineWeightEdge(int time, int distance) {
        this.time = time;
        this.distance = distance;
    }

    @Override
    protected double getWeight() {
        if (isWeightTime) {
            return time;
        }
        return distance;
    }

    public void weightIsTime() {
        isWeightTime = true;
    }

    public void weightIsDistance() {
        isWeightTime = false;
    }
}
