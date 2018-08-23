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
@Table(name="campaigns")
public class Campaign implements Serializable{
    @Id
    @Column(name="campaign_id")
    private int campaignId;
    @Column(name="active")
    private boolean active;
    @Column(name="campaign_name")
    private String campaignName;

    public Campaign update(Campaign c){
        this.campaignId = c.campaignId;
        this.campaignName = c.campaignName;
        this.active = c.active;
        return this;
    }
    
    public Campaign() {
    }

    public Campaign(int campaignId, boolean active, String campaignName) {
        this.campaignId = campaignId;
        this.active = active;
        this.campaignName = campaignName;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
}
