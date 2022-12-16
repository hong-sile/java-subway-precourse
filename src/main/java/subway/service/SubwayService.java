package subway.service;

import subway.command.FindCommand;
import subway.domain.AllRoutes;
import subway.dto.EdgeDto;
import subway.dto.LineWeightDto;

public class SubwayService {
    private final AllRoutes allRoutes = new AllRoutes();

    public LineWeightDto routeLookup(EdgeDto edgeDto, FindCommand command) {

        return null;
    }
}
