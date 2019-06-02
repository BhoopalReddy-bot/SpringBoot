package org.vision.springrest.monitored.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoredEndpointsService {

    @Autowired
    private MonitoredEndpointsRepository monitoredEndpointsRepository;

    public List<MonitoredEndpoints> getAllEndpoints(){
        ArrayList<MonitoredEndpoints> endpointsList = new ArrayList<>();
        monitoredEndpointsRepository.findAll().forEach(e -> endpointsList.add(e));
        return endpointsList;
    }

    public void addEndpoint(MonitoredEndpoints endpoint){
        monitoredEndpointsRepository.save(endpoint);
    }

    public void deleteEndpoint(Long id){
        monitoredEndpointsRepository.deleteById(id);
    }

    public Optional<MonitoredEndpoints> getEndpointById(Long id){
        return monitoredEndpointsRepository.findById(id);
    }


    public void updateEndpointPayload(MonitoredEndpoints endpoint){
        monitoredEndpointsRepository.save(endpoint);
    }

    public void updateEndpointUrl(MonitoredEndpoints endpoint, Long id){
        endpoint.setId(id);
        monitoredEndpointsRepository.save(endpoint);
    }

    public List<MonitoredEndpoints> getRequestedQuantityOfFirstEndpoints(int quantity){
        ArrayList<MonitoredEndpoints> endpointsList = new ArrayList<>();
        List<MonitoredEndpoints> temp = getAllEndpoints();
        for(int i = 0; i < temp.size(); i++){
            endpointsList.add(temp.get(i));
        }
        return endpointsList;
    }

    public List<MonitoredEndpoints> getUserRequestedQuantityOfEndpoints(int quantity, Long userId){
        ArrayList<MonitoredEndpoints> endpointsList = new ArrayList<>();
        List<MonitoredEndpoints> temp = getAllEndpoints();
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getOwner().getId().equals(userId)){
                endpointsList.add(temp.get(i));
            }
        }
        return endpointsList.subList(0, quantity);
    }

    public List<MonitoredEndpoints> getAuthorisedQuantityEndpoints(Long userId, String token){
        ArrayList<MonitoredEndpoints> endpointsList = new ArrayList<>();
        List<MonitoredEndpoints> temp = getAllEndpoints();
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getOwner().getId().equals(userId) && temp.get(i).getOwner().getAccessToken().equals(token)){
                endpointsList.add(temp.get(i));
            }
        }
        return endpointsList;
    }

    public List<MonitoredEndpoints> getAllEndpointsByUserId(Long userId){
        ArrayList<MonitoredEndpoints> endpointsList = new ArrayList<>();
        List<MonitoredEndpoints> temp = getAllEndpoints();
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getOwner().getId().equals(userId)){
                endpointsList.add(temp.get(i));
            }
        }
        return endpointsList;
    }

    public MonitoredEndpoints getAuthorisedEndpoint(Long userId, Long id, String token){
        List<MonitoredEndpoints> temp = getAllEndpoints();
        MonitoredEndpoints obj = new MonitoredEndpoints();
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getOwner().getId().equals(userId) && (temp.get(i).getId().equals(id)) && (temp.get(i).getOwner().getAccessToken().equals(token))){
                obj = temp.get(i);
            }
        }
        return obj;
    }
}
