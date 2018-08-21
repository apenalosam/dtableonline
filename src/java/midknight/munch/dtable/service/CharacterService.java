package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Character;
/**
 *
 * @author KODE
 */
public interface CharacterService {
    public Character create(Character c);
    public Character get(Integer characterId);
    public List<Object> showCharacters (String username);
    public List<Character> getAll();
    public List<Character> getByUsername(String username);
    public List<Character> getByCampaignId(int campaignId);
    public Character update(Character c);
    public boolean exists(Integer id);
    public int totalRegistry(String query);
}
