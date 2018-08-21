package midknight.munch.dtable.repository;

import java.util.List;
import midknight.munch.dtable.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author KODE
 */
public abstract interface CharacterRepository extends JpaRepository<Character, Integer>{
    public abstract List<Character> findByUsername(String username);
    public abstract List<Character> findByCampaignId(Integer campaignId);
}
