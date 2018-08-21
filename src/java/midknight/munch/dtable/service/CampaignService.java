/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import midknight.munch.dtable.model.Campaign;

/**
 *
 * @author XMY6267
 */
public interface CampaignService {
    public Campaign create(Campaign c);
    public Campaign get(Integer campaignId);
    public Campaign update(Campaign c);
    public boolean exists(Integer campaignId);
    public boolean exists(String campaignName);
}
