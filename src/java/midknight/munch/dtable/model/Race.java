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
import javax.servlet.http.HttpServletRequest;
import midknight.munch.dtable.util.Util;

/**
 *
 * @author XMY6267
 */
@Entity
@Table(name="race", schema="dunganddrag")
public class Race implements Serializable{
    @Id
    @Column(name="race_id")
    private int raceId;
    @Column(name="race_name")
    private String raceName;
    @Column(name="base_str")
    private int baseStr;
    @Column(name="base_dex")
    private int baseDex;
    @Column(name="base_con")
    private int baseCon;
    @Column(name="base_int")
    private int baseInt;
    @Column(name="base_wis")
    private int baseWis;
    @Column(name="base_cha")
    private int baseCha;
    @Column(name="adulthood")
    private int adulthood;
    @Column(name="avg_age")
    private int avgAge;
    @Column(name="typical_alignment")
    private String typicalAlignment;
    @Column(name="race_size")
    private String size;
    @Column(name="land_speed")
    private int landSpeed;
    @Column(name="armor_speed")
    private int armorSpeed;
    @Column(name="swim_speed")
    private int swimSpeed;

    public Race() {
    }
    
    public Race(HttpServletRequest request){
        this.raceId = Integer.parseInt(request.getParameter("raceId"));
        this.raceName = Util.decode(request.getParameter("raceName"));
        this.baseStr = Integer.parseInt(request.getParameter("baseStr"));
        this.baseDex = Integer.parseInt(request.getParameter("baseDex"));
        this.baseCon = Integer.parseInt(request.getParameter("baseCon"));
        this.baseInt = Integer.parseInt(request.getParameter("baseInt"));
        this.baseWis = Integer.parseInt(request.getParameter("baseWis"));
        this.baseCha = Integer.parseInt(request.getParameter("baseCha"));
        this.adulthood = Integer.parseInt(request.getParameter("adulthood"));
        this.avgAge = Integer.parseInt(request.getParameter("avgAge"));
        this.typicalAlignment = Util.decode(request.getParameter("typicalAlignment"));
        this.size = Util.decode(request.getParameter("size"));
        this.landSpeed = Integer.parseInt(request.getParameter("landSpeed"));
        this.armorSpeed = Integer.parseInt(request.getParameter("armorSpeed"));
        this.swimSpeed = Integer.parseInt(request.getParameter("swimSpeed"));
    }

    public Race(int raceId, String raceName, int baseStr, int baseDex, int baseCon, int baseInt, int baseWis, int baseCha, int adulthood, int avgAge, String typicalAlignment, String size, int landSpeed, int armorSpeed, int swimSpeed) {
        this.raceId = raceId;
        this.raceName = raceName;
        this.baseStr = baseStr;
        this.baseDex = baseDex;
        this.baseCon = baseCon;
        this.baseInt = baseInt;
        this.baseWis = baseWis;
        this.baseCha = baseCha;
        this.adulthood = adulthood;
        this.avgAge = avgAge;
        this.typicalAlignment = typicalAlignment;
        this.size = size;
        this.landSpeed = landSpeed;
        this.armorSpeed = armorSpeed;
        this.swimSpeed = swimSpeed;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
    }

    public int getBaseDex() {
        return baseDex;
    }

    public void setBaseDex(int baseDex) {
        this.baseDex = baseDex;
    }

    public int getBaseCon() {
        return baseCon;
    }

    public void setBaseCon(int baseCon) {
        this.baseCon = baseCon;
    }

    public int getBaseInt() {
        return baseInt;
    }

    public void setBaseInt(int baseInt) {
        this.baseInt = baseInt;
    }

    public int getBaseWis() {
        return baseWis;
    }

    public void setBaseWis(int baseWis) {
        this.baseWis = baseWis;
    }

    public int getBaseCha() {
        return baseCha;
    }

    public void setBaseCha(int baseCha) {
        this.baseCha = baseCha;
    }

    public int getAdulthood() {
        return adulthood;
    }

    public void setAdulthood(int adulthood) {
        this.adulthood = adulthood;
    }

    public int getAvgAge() {
        return avgAge;
    }

    public void setAvgAge(int avgAge) {
        this.avgAge = avgAge;
    }

    public String getTypicalAlignment() {
        return typicalAlignment;
    }

    public void setTypicalAlignment(String typicalAlignment) {
        this.typicalAlignment = typicalAlignment;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getLandSpeed() {
        return landSpeed;
    }

    public void setLandSpeed(int landSpeed) {
        this.landSpeed = landSpeed;
    }

    public int getArmorSpeed() {
        return armorSpeed;
    }

    public void setArmorSpeed(int armorSpeed) {
        this.armorSpeed = armorSpeed;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }
    
}
