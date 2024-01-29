package pl.drybanski.court.court;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourtController {
    private CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

}
