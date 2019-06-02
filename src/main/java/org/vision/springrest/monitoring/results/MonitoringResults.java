package org.vision.springrest.monitoring.results;

import org.hibernate.annotations.UpdateTimestamp;
import org.vision.springrest.monitored.endpoints.MonitoredEndpoints;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="monitoringresult")
public class MonitoringResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @UpdateTimestamp
    private Date checkDate;
    private int httpStatus;
    private String returnedPayload;
    @ManyToOne
    private MonitoredEndpoints monitoredEndpoint;

    public MonitoringResults(){

    }

    public MonitoringResults(int httpStatus, String returnedPayload, Long endpointId, Long userId){
        this.httpStatus = httpStatus;
        this.returnedPayload = returnedPayload;
        this.monitoredEndpoint = new MonitoredEndpoints(endpointId, userId);
    }

    public MonitoringResults(Long id, Date checkDate, int httpStatus, String returnedPayload, MonitoredEndpoints monitoredEndpoint) {
        this.id = id;
        this.checkDate = checkDate;
        this.httpStatus = httpStatus;
        this.returnedPayload = returnedPayload;
        this.monitoredEndpoint = monitoredEndpoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getReturnedPayload() {
        return returnedPayload;
    }

    public void setReturnedPayload(String returnedPayload) {
        this.returnedPayload = returnedPayload;
    }

    public MonitoredEndpoints getMonitoredEndpoint() {
        return monitoredEndpoint;
    }

    public void setMonitoredEndpoint(MonitoredEndpoints monitoredEndpoint) {
        this.monitoredEndpoint = monitoredEndpoint;
    }
}
