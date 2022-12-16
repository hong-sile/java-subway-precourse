package subway.service;

import subway.command.FindCommand;
import subway.domain.Routes;
import subway.dto.EdgeDto;
import subway.dto.FindResultDto;

public class SubwayService {
    private final Routes routes = new Routes();

    public FindResultDto routeLookup(EdgeDto edgeDto, FindCommand command) {
        FindResultDto route = routes.findRoute(edgeDto, command);
        return route;
    }
}
