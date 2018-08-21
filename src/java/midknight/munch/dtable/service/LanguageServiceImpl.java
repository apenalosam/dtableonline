/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import midknight.munch.dtable.model.Language;
import midknight.munch.dtable.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XMY6267
 */
@Service
@Transactional
public class LanguageServiceImpl implements LanguageService{
    
    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<Language> getVarious(ArrayList<Integer> ids){
        List<Language> requested = new ArrayList<>();
        try{
            ids.stream().filter((id) -> (exists(id))).forEach((id) -> {
                requested.add(get(id));
            });
        }
        catch(Exception e){
            requested.add(get(1));
            e.printStackTrace();
        }
        return requested;
    }
    @Override
    public List<Language> getVariousByName(ArrayList<String> names){
        List<Language> requested = new ArrayList<>();
        try{
            names.stream().forEach((name) -> {
                requested.add(getByName(name));
            });
        }
        catch(Exception e){
            requested.add(getByName("common"));
            e.printStackTrace();
        }
        return requested;
    }
    
    @Override
    public Language create(Language l) {
        return languageRepository.save(l);
    }

    @Override
    public Language get(Integer languageId) {
        return languageRepository.getOne(languageId);
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public boolean exists(Integer languageId) {
        return languageRepository.exists(languageId);
    }

    @Override
    public Language getByName(String languageName) {
        return languageRepository.findByName(languageName);
    }
    
}
