/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import midknight.munch.dtable.model.Campaign;
import midknight.munch.dtable.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XMY6267
 */
@Service
@Transactional
public class CampaignServiceImpl implements CampaignService{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    CampaignRepository campaignRepository;

    @Override
    public Campaign create(Campaign c) {
        return campaignRepository.save(c);
    }

    @Override
    public Campaign get(Integer campaignId) {
        return campaignRepository.findByCampaignId(campaignId);
    }

    @Override
    public Campaign update(Campaign c) {
        Campaign camp = get(c.getCampaignId());
        camp.update(c);
        return camp;
    }

    @Override
    public boolean exists(Integer campaignId) {
        return campaignRepository.exists(campaignId);
    }

    @Override
    public boolean exists(String campaignName) {
        StringBuilder sql = new StringBuilder("SELECT count(campaign_name) AS total");
        sql.append(" FROM campaigns ");
        sql.append(" WHERE campaign_name = ").append(campaignName);
        boolean existe = false;
        List<Object> l = entityManager.createNativeQuery(sql.toString()).getResultList();
        if(!l.isEmpty()) {
            if(Integer.parseInt(String.valueOf(l.get(0))) > 0) {
                existe = true;
            }
        }
        return existe ;
    }
        
}
