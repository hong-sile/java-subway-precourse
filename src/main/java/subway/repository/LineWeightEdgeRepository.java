package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.LineWeightEdge;

public class LineWeightEdgeRepository {
    private static final List<LineWeightEdge> lineWeightEdges = new ArrayList<>();

    public static final List<LineWeightEdge> lineWeightEdges() {
        return Collections.unmodifiableList(lineWeightEdges);
    }

    public static void addLine(LineWeightEdge lineWeightEdge) {
        lineWeightEdges.add(lineWeightEdge);
    }

    public static boolean deleteLineByLineWeightEdge(LineWeightEdge lineWeightEdge) {
        return lineWeightEdges.removeIf(we -> Objects.equals(lineWeightEdge, we));
    }

    public static void deleteAll() {
        lineWeightEdges.clear();
    }
}
