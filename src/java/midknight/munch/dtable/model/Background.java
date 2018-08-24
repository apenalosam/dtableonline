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
@Table(name="backgrounds", schema="dunganddrag")
public class Background implements Serializable{
    @Id
    @Column(name="background_id")
    private int id;
    @Column(name="background_name")
    private String name;
    @Column(name="skill_one")
    private String skillOne;
    @Column(name="skill_two")
    private String skillTwo;
    @Column(name="languages_number")
    private int languagesNumber;
    @Column(name="tool_one")
    private String toolOne;
    @Column(name="tool_two")
    private int toolTwo;
    @Column(name="tool_type_one")
    private String toolTypeOne;
    @Column(name="tool_type_two")
    private int toolTypeTwo;

    public Background() {
    }

    public Background(int id, String name, String skillOne, String skillTwo, int languagesNumber, String toolOne, int toolTwo, String toolTypeOne, int toolTypeTwo) {
        this.id = id;
        this.name = name;
        this.skillOne = skillOne;
        this.skillTwo = skillTwo;
        this.languagesNumber = languagesNumber;
        this.toolOne = toolOne;
        this.toolTwo = toolTwo;
        this.toolTypeOne = toolTypeOne;
        this.toolTypeTwo = toolTypeTwo;
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

    public String getSkillOne() {
        return skillOne;
    }

    public void setSkillOne(String skillOne) {
        this.skillOne = skillOne;
    }

    public String getSkillTwo() {
        return skillTwo;
    }

    public void setSkillTwo(String skillTwo) {
        this.skillTwo = skillTwo;
    }

    public int getLanguagesNumber() {
        return languagesNumber;
    }

    public void setLanguagesNumber(int languagesNumber) {
        this.languagesNumber = languagesNumber;
    }

    public String getToolOne() {
        return toolOne;
    }

    public void setToolOne(String toolOne) {
        this.toolOne = toolOne;
    }

    public int getToolTwo() {
        return toolTwo;
    }

    public void setToolTwo(int toolTwo) {
        this.toolTwo = toolTwo;
    }

    public String getToolTypeOne() {
        return toolTypeOne;
    }

    public void setToolTypeOne(String toolTypeOne) {
        this.toolTypeOne = toolTypeOne;
    }

    public int getToolTypeTwo() {
        return toolTypeTwo;
    }

    public void setToolTypeTwo(int toolTypeTwo) {
        this.toolTypeTwo = toolTypeTwo;
    }
    
    
}
