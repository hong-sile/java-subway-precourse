package subway.service;

import subway.command.FindCommand;
import subway.domain.AllRoutes;
import subway.dto.EdgeDto;
import subway.dto.FindResultDto;

public class SubwayService {
    private final AllRoutes allRoutes = new AllRoutes();

    public FindResultDto routeLookup(EdgeDto edgeDto, FindCommand command) {
        FindResultDto route = allRoutes.findRoute(edgeDto, command);
        return route;
    }
}
