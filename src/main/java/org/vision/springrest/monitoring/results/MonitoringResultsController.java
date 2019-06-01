package org.vision.springrest.monitoring.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MonitoringResultsController {

    @Autowired
    private MonitoringResultsService mrService;

    @RequestMapping("/{userId}/endpoints/{endpointId}/results")
    private List<MonitoringResults> getResultsForUser(@PathVariable Long userId, @PathVariable Long endpointId, @RequestParam String token){
        return mrService.getResultsForUser(userId, endpointId, token);
    }

    @RequestMapping("/endpoints/results")
    private List<MonitoringResults> getAllResults(){
        return mrService.getAllResults();
    }

}
