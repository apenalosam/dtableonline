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
@Table(name="tools", schema="dunganddrag")
public class Tool implements Serializable{
    @Id
    @Column(name="tool_id")
    private int toolId;
    @Column(name="tool_name")
    private String toolName;
    @Column(name="tool_type")
    private int toolType;
    @Column(name="cost")
    private int cost;
    @Column(name="weight")
    private int weight;
    @Column(name="tool_type_name")
    private String toolTypeName;
    @Column(name="description")
    private String description;

    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public int getToolType() {
        return toolType;
    }

    public void setToolType(int toolType) {
        this.toolType = toolType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getToolTypeName() {
        return toolTypeName;
    }

    public void setToolTypeName(String toolTypeName) {
        this.toolTypeName = toolTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    public Tool() {
    }

    public Tool(int toolId, String toolName, int toolType, int cost, int weight, String toolTypeName, String description) {
        this.toolId = toolId;
        this.toolName = toolName;
        this.toolType = toolType;
        this.cost = cost;
        this.weight = weight;
        this.toolTypeName = toolTypeName;
        this.description = description;
    }
    
    
}
