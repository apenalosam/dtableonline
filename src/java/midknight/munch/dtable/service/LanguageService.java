/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.ArrayList;
import java.util.List;
import midknight.munch.dtable.model.Language;

/**
 *
 * @author XMY6267
 */
public interface LanguageService {
    public Language create(Language l);
    public Language get(Integer languageId);
    public List<Language> findAll();
    public boolean exists(Integer languageId);
    public Language getByName(String languageName);
    public List<Language> getVarious(ArrayList<Integer> ids);
    public List<Language> getVariousByName(ArrayList<String> names);
}
