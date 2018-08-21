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
 * @author XMY6267
 */
@Entity
@Table(name="backgrounds", schema="dunganddrag")
public class Background implements Serializable{
    
    @Id
    @Column(name="background_id")
    private int backgroundId;
    @Column(name="background_ name")
    private String backgroundName;
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

    public Background(int backgroundId, String backgroundName, String skill1, String skill2, int languages, String tool1, int tool2, String toolType1, int toolType2) {
        this.backgroundId = backgroundId;
        this.backgroundName = backgroundName;
        this.skillOne = skill1;
        this.skillTwo = skill2;
        this.languagesNumber = languages;
        this.toolOne = tool1;
        this.toolTwo = tool2;
        this.toolTypeOne = toolType1;
        this.toolTypeTwo = toolType2;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public String getBackgroundName() {
        return backgroundName;
    }

    public void setBackgroundName(String backgroundName) {
        this.backgroundName = backgroundName;
    }

    public String getSkill1() {
        return skillOne;
    }

    public void setSkill1(String skill1) {
        this.skillOne = skill1;
    }

    public String getSkill2() {
        return skillTwo;
    }

    public void setSkill2(String skill2) {
        this.skillTwo = skill2;
    }

    public int getLanguages() {
        return languagesNumber;
    }

    public void setLanguages(int languages) {
        this.languagesNumber = languages;
    }

    public String getTool1() {
        return toolOne;
    }

    public void setTool1(String tool1) {
        this.toolOne = tool1;
    }

    public int getTool2() {
        return toolTwo;
    }

    public void setTool2(int tool2) {
        this.toolTwo = tool2;
    }

    public String getToolType1() {
        return toolTypeOne;
    }

    public void setToolType1(String toolType1) {
        this.toolTypeOne = toolType1;
    }

    public int getToolType2() {
        return toolTypeTwo;
    }

    public void setToolType2(int toolType2) {
        this.toolTypeTwo = toolType2;
    }
    
    
}
