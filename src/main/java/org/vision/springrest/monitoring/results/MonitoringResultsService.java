package org.vision.springrest.monitoring.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitoringResultsService {

    @Autowired
    private MonitoringResultsRepository mrRepository;

    public List<MonitoringResults> getResultsForUser(Long userId, Long endpointId, String token){
        ArrayList<MonitoringResults> resultList = new ArrayList<>();
        mrRepository.findAll().forEach(r -> {
            if((r.getMonitoredEndpoint().getOwner().getId().equals(userId))&&(r.getMonitoredEndpoint().getOwner().getAccessToken().equals(token))){
                resultList.add(r);
            }
        });
        return resultList;
    }

    public List<MonitoringResults> getAllResults(){
        ArrayList<MonitoringResults> resultsList = new ArrayList<>();
        mrRepository.findAll().forEach(r -> resultsList.add(r));
        return resultsList;
    }

    public void addObservation(int status, String payload, Long userId, Long endpointId){
        MonitoringResults observation = new MonitoringResults(status, payload, userId, endpointId);
        mrRepository.save(observation);
    }
}
