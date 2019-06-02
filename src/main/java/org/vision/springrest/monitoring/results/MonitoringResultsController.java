package org.vision.springrest.monitoring.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MonitoringResultsController {

    @Autowired
    private MonitoringResultsService monitoringResultsService;

    @RequestMapping("/{userId}/endpoints/{endpointId}/results/secure")
    private List<MonitoringResults> getResultsForUserAndId(@PathVariable Long userId, @PathVariable Long endpointId, @RequestParam String token){
        return monitoringResultsService.getResultsForUser(userId, endpointId, token);
    }

    @RequestMapping("/{userId}/endpoints/results/secure")
    private List<MonitoringResults> getAllResults(@PathVariable Long userId, @RequestParam String token){
        return monitoringResultsService.getAllResults(userId, token);
    }

    @RequestMapping("/endpoints/results/{id}/secure")
    private void deleteResultById(@PathVariable Long id){
        monitoringResultsService.deleteResultById(id);
    }

}
