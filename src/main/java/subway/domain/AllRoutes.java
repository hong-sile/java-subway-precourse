package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.command.FindCommand;
import subway.dto.EdgeDto;

public class AllRoutes {
    private final WeightedMultigraph<Station, LineWeightEdge> routes;

    public AllRoutes() {
        routes = new WeightedMultigraph<>(LineWeightEdge.class);
    }

    public LineWeightEdge findRoute(EdgeDto edgeDto, FindCommand command) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(routes);
        GraphPath path = dijkstraShortestPath.getPath(edgeDto.getStartSource().getStation(),
                edgeDto.getDestinationSource().getStation());
        return null;
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
