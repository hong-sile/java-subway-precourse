package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;

public class LineWeightEdge extends DefaultWeightedEdge {
    private static boolean isWeightTime;
    private final int time;
    private final int distance;

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

    public static void weightIsTime() {
        isWeightTime = true;
    }

    public static void weightIsDistance() {
        isWeightTime = false;
    }
}
