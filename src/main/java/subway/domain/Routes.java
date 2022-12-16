package subway.domain;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.command.FindCommand;
import subway.dto.EdgeDto;
import subway.dto.FindResultDto;

public class Routes {
    private final WeightedMultigraph<Station, LineWeightEdge> routes;

    public Routes() {
        routes = new WeightedMultigraph<>(LineWeightEdge.class);
    }

    public FindResultDto findRoute(EdgeDto edgeDto, FindCommand command) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(routes);
        GraphPath path = dijkstraShortestPath.getPath(edgeDto.getStartSource().getStation(),
                edgeDto.getDestinationSource().getStation());
        return calculateValue(path);
    }

    private FindResultDto calculateValue(GraphPath path) {
        List<LineWeightEdge> edgeList = path.getEdgeList();
        int time = edgeList.stream()
                .mapToInt(LineWeightEdge::getTime)
                .sum();
        int distance = edgeList.stream()
                .mapToInt(LineWeightEdge::getDistance)
                .sum();
        return new FindResultDto(time, distance, path.getVertexList());
    }

    private void weightDecide(FindCommand command) {
        if (command.isSmallestTime()) {
            LineWeightEdge.weightIsTime();
        }
        if (command.isSmallestTime()) {
            LineWeightEdge.weightIsDistance();
        }
    }
}
