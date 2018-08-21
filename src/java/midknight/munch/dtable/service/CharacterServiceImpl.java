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
import midknight.munch.dtable.model.Character;
import midknight.munch.dtable.repository.CharacterRepository;
import midknight.munch.dtable.util.CharacterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KODE
 */
@Service
@Transactional
public class CharacterServiceImpl implements CharacterService{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private CharacterRepository characterRepository;
    
    @Override
    public Character create(Character c) {
        return characterRepository.save(c);
    }

    @Override
    public Character get(Integer characterId) {
        System.out.println("About to get character");
        return characterRepository.findOne(characterId);
    }

    @Override
    public List<Character> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public List<Character> getByUsername(String username) {
        return characterRepository.findByUsername(username);
    }

    @Override
    public List<Character> getByCampaignId(int campaignId) {
         return characterRepository.findByCampaignId(campaignId);
    }

    @Override
    public Character update(Character c) {
        Character cha = get(c.getCharacterId());
        cha.update(c);
        return cha;
    }

    @Override
    public boolean exists(Integer id) {
        return characterRepository.exists(id);
    }
    
    @Override
    public List<Object> showCharacters (String username){        
        StringBuilder sql = new StringBuilder("SELECT ");
        sql.append("c.character_name, cl.class_name, c.lvl, r.race_name, camp.campaign_name, c.character_id");
        sql.append(" FROM dynamic_dnd.characters AS c ");
        sql.append(" INNER JOIN dynamic_dnd.campaigns AS camp ON c.campaign_id = camp.campaign_id ");
        sql.append(" INNER JOIN dunganddrag.clas AS cl ON c.class_id = cl.class_id ");
        sql.append(" INNER JOIN dunganddrag.race AS r ON c.race_id = r.race_id ");
        sql.append("WHERE (c.username = '");
        sql.append(username).append("');");
        return CharacterUtil.getCharacter(entityManager.createNativeQuery(sql.toString()).getResultList());
    }
    @Override
    public int totalRegistry(String query) {
        StringBuilder sql = new StringBuilder("SELECT ");
        sql.append(" c.character_id ");
        sql.append(" FROM characters AS c INNER JOIN campaigns AS camp");
        sql.append(CharacterUtil.searchRegistry(query));
        return entityManager.createNativeQuery(sql.toString()).getResultList().size();
    }
}
