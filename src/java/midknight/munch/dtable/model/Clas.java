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
 * @author KODE
 */
@Entity
@Table(name="clas", schema="dunganddrag")
public class Clas implements Serializable{
    @Id
    @Column(name="class_id")
    private int classId;
    @Column(name="class_name")
    private String clasName;
    @Column(name="hit_die")
    private int hitDie;
    @Column(name="primary_ability")
    private String primaryAbility;
    @Column(name="saves")
    private String saves;
    @Column(name="hit_points")
    private int hitPoints;
    @Column(name="hit_points_optional")
    private int hitPointsOptional;
    @Column(name="armor_prof")
    private String armorProf;
    @Column(name="weapon_prof")
    private String weaponProf;
    @Column(name="tools")
    private String tools;

    public Clas() {
    }

    @Override
    public String toString() {
        return "Clas{" + "classId=" + classId + ", clasName=" + clasName + ", hitDie=" + hitDie + ", primaryAbility=" + primaryAbility + ", saves=" + saves + ", hitPoints=" + hitPoints + ", hitPointsOptional=" + hitPointsOptional + ", armorProf=" + armorProf + ", weaponProf=" + weaponProf + ", tools=" + tools + '}';
    }
    
    public Clas(HttpServletRequest request) {
        this.classId = Integer.parseInt(request.getParameter("classId"));
        this.clasName = Util.decode(request.getParameter("className"));
        this.hitDie = Integer.parseInt(request.getParameter("hitDie"));
        this.primaryAbility = Util.decode(request.getParameter("primaryAbility"));
        this.saves = Util.decode(request.getParameter("saves"));
        this.hitPoints = Integer.parseInt(request.getParameter("hitPoints"));
        this.hitPointsOptional = Integer.parseInt(request.getParameter("hitPointsOptional"));
        this.armorProf = Util.decode(request.getParameter("armorProf"));
        this.weaponProf = Util.decode(request.getParameter("weaponProf"));
        this.tools = Util.decode(request.getParameter("tools"));
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClasName() {
        return clasName;
    }

    public void setClasName(String className) {
        this.clasName = className;
    }

    public int getHitDie() {
        return hitDie;
    }

    public void setHitDie(int hitDie) {
        this.hitDie = hitDie;
    }

    public String getPrimaryAbility() {
        return primaryAbility;
    }

    public void setPrimaryAbility(String primaryAbility) {
        this.primaryAbility = primaryAbility;
    }

    public String getSaves() {
        return saves;
    }

    public void setSaves(String saves) {
        this.saves = saves;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getHitPointsOptional() {
        return hitPointsOptional;
    }

    public void setHitPointsOptional(int hitPointsOptional) {
        this.hitPointsOptional = hitPointsOptional;
    }

    public String getArmorProf() {
        return armorProf;
    }

    public void setArmorProf(String armorProf) {
        this.armorProf = armorProf;
    }

    public String getWeaponProf() {
        return weaponProf;
    }

    public void setWeaponProf(String weaponProf) {
        this.weaponProf = weaponProf;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }
}
