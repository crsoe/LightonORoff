package org.example.maketable.TelemetryRestAPI;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class TelemetryController {


    private final TelemetryRepo repo;

    TelemetryController(TelemetryRepo repo) {
        this.repo = repo;
    }

    @RequestMapping("TelemetryModel")
    public List<TelemetryModel> getAllTELEMETRY() {
        return repo.findAll();
    }
}