/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.ArrayList;
import java.util.List;
import midknight.munch.dtable.model.Background;
import midknight.munch.dtable.repository.BackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XMY6267
 */
@Service
@Transactional
public class BackgroundServiceImpl implements BackgroundService{
    
    @Autowired
    BackgroundRepository backgroundRepository;

    @Override
    public Background create(Background b) {
        return backgroundRepository.save(b);
    }

    @Override
    public Background get(Integer id) {
        return backgroundRepository.findOne(id);
    }

    @Override
    public List<Background> getAll() {
        //return backgroundRepository.findAll();
        List<Background> backgrounds = new ArrayList<>();
        Background background;
        int i = 1;
        boolean finish = false;
        do{
            if(exists(i)){
                background = get(i);
                backgrounds.add(background);
                i++;
            }
            else{
                finish = true;
            }
        }
        while(!finish);
        return backgrounds;
    }

    @Override
    public boolean exists(Integer id) {
        return backgroundRepository.exists(id);
    }
    
}
