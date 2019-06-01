package org.vision.springrest.monitored.endpoints;

import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.vision.springrest.user.User;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name="monitoredendpoint")
public class MonitoredEndpoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    private int monitoredInterval;

    @ManyToOne
    private User owner;

    public MonitoredEndpoints() {
    }

    public MonitoredEndpoints(Long id, String name, String url, Date createdAt, Date updatedAt, int monitoredInterval, Long ownerId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.monitoredInterval = monitoredInterval;
        this.owner = new User(ownerId, "", "", "");
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getMonitoredInterval() {
        return monitoredInterval;
    }

    public void setMonitoredInterval(int monitoredInterval) {
        this.monitoredInterval = monitoredInterval;
    }
}
