/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author KODE
 */
@Entity
@Table(name="vehicles", schema="dunganddrag")
public class Vehicle implements Serializable{
    @Id
    @Column(name="vehicle_id")
    private int id;
    @Column(name="vehicle_name")
    private String name;
    @Column(name="cost")
    private int cost;
    @Column(name="coin")
    private String coin;
    @Column(name="speed")
    private float speed;
    @Column(name="capacity")
    private int capacity;
    @Column(name="type")
    private String type;

    public Vehicle() {
    }

    public Vehicle(int id, String name, int cost, String coin, float speed, int capacity, String type) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.coin = coin;
        this.speed = speed;
        this.capacity = capacity;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
