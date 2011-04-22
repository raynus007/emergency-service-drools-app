/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author salaboy
 */
public class Emergency implements Serializable {

    public enum EmergencyType {

        FIRE, CAR_CRASH, HEART_ATTACK, ROBBERY
    };
    public static AtomicLong incrementalId = new AtomicLong();
    
    private Long id;
    private EmergencyType type;
    private Location location;
    private int nroOfPeople;
    private Date approximateTime;
    private Call call;
    
    
    

    public Emergency() {
        this.id = Emergency.incrementalId.getAndIncrement();
    }

    public void setNroOfPeople(int nroOfPeople) {
        this.nroOfPeople = nroOfPeople;
    }

    public int getNroOfPeople() {
        return nroOfPeople;
    }
    
    public Date getApproximateTime() {
        return approximateTime;
    }

    public void setApproximateTime(Date approximateTime) {
        this.approximateTime = approximateTime;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public EmergencyType getType() {
        return type;
    }

    public void setType(EmergencyType type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = EmergencyType.valueOf(type);
    }

    @Override
    public String toString() {
        return "Emergency{" + "id=" + id + ", call=" + call + ", location=" + location + ", type=" + type + ", approximateTime=" + approximateTime + '}';
    }
    
    
}
