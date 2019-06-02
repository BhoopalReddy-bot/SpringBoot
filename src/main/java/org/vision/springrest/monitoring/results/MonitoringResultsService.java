package org.vision.springrest.monitoring.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitoringResultsService {

    @Autowired
    private MonitoringResultsRepository monitoringResultsRepository;

    public List<MonitoringResults> getResultsForUser(Long userId, Long endpointId, String token){
        ArrayList<MonitoringResults> resultList = new ArrayList<>();
        monitoringResultsRepository.findAll().forEach(r -> {
            if((r.getMonitoredEndpoint().getOwner().getId().equals(userId))&&(r.getMonitoredEndpoint().getOwner().getAccessToken().equals(token))){
                resultList.add(r);
            }
        });
        return resultList;
    }

    public List<MonitoringResults> getAllResults(Long userId, String token){
        ArrayList<MonitoringResults> resultsList = new ArrayList<>();
        monitoringResultsRepository.findAll().forEach(r -> {
            if((r.getMonitoredEndpoint().getOwner().getId().equals(userId)) && (r.getMonitoredEndpoint().getOwner().getAccessToken().equals(token))){
                resultsList.add(r);
            }
        });
        return resultsList;
    }

    public void addObservation(int status, String payload, Long userId, Long endpointId){
        MonitoringResults observation = new MonitoringResults(status, payload, endpointId, userId);
        monitoringResultsRepository.save(observation);
    }

    public void deleteResultById(Long id){
        monitoringResultsRepository.deleteById(id);
    }

    public void TestMeCallMethod(){
        System.out.println("HELLO FROM THE OTHER SIDE");
    }
}
