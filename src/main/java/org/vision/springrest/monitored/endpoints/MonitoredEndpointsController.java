package org.vision.springrest.monitored.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vision.springrest.user.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class MonitoredEndpointsController {

    @Autowired
    private MonitoredEndpointsService monitoredEndpointsService;

    @RequestMapping("/endpoints")
    public List<MonitoredEndpoints> getAllEndpoints(){
        return monitoredEndpointsService.getAllEndpoints();
    }

    @RequestMapping("/endpoints/{id}")
    public Optional<MonitoredEndpoints> getEndpointById(@PathVariable Long id){
        return monitoredEndpointsService.getEndpointById(id);
    }

    @RequestMapping("/{userId}/endpoints")
    public List<MonitoredEndpoints> getAllEndpointsByUserId(@PathVariable Long userId){
        return monitoredEndpointsService.getAllEndpointsByUserId(userId);
    }

    @RequestMapping(value="/{userId}/endpoints", method=RequestMethod.POST)
    public void addEndpoint(@RequestBody MonitoredEndpoints endpoint, @PathVariable Long userId){
        endpoint.setOwner(new User(userId, "", "", ""));
        monitoredEndpointsService.addEndpoint(endpoint);
    }

    @RequestMapping(value="/{userId}/endpoints", method=RequestMethod.PUT)
    public void updateEndpointPayload(@RequestBody MonitoredEndpoints endpoint, @PathVariable Long userId){
        endpoint.setOwner(new User(userId, "", "", ""));
        monitoredEndpointsService.updateEndpointPayload(endpoint);
    }

    @RequestMapping(value="/{userId}/endpoints/{id}", method=RequestMethod.PUT)
    public void updateEndpointUrl(@RequestBody MonitoredEndpoints endpoint, @PathVariable Long userId, @PathVariable Long id){
        endpoint.setOwner(new User(userId, "", "", ""));
        monitoredEndpointsService.updateEndpointUrl(endpoint, id);
    }

    @RequestMapping(value="/endpoints/{id}", method=RequestMethod.DELETE)
    public void deleteEndpoint(@PathVariable Long id){
        monitoredEndpointsService.deleteEndpoint(id);
    }

    @RequestMapping("/endpoints={quantity}")
    public List<MonitoredEndpoints> getRequestedQuantityOfFirstEndpoints(@PathVariable int quantity){
        return monitoredEndpointsService.getRequestedQuantityOfFirstEndpoints(quantity);
    }

    @RequestMapping("/{userId}/endpoints={quantity}")
    public List<MonitoredEndpoints> getUserRequestedQuantityOfEndpoints(@PathVariable Long userId, @PathVariable int quantity){
        return monitoredEndpointsService.getUserRequestedQuantityOfEndpoints(quantity, userId);
    }

    @RequestMapping("/{userId}/endpoints={quantity}&token={token}")
    public List<MonitoredEndpoints> getAuthorisedQuantityEndpoints(@PathVariable Long userId, @PathVariable int quantity, @PathVariable String token){
        return monitoredEndpointsService.getAuthorisedQuantityEndpoints(quantity, userId, token);
    }
}
