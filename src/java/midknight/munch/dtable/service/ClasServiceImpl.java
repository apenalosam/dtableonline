/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import midknight.munch.dtable.model.Clas;
import midknight.munch.dtable.repository.ClasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XMY6267
 */
@Service
@Transactional
public class ClasServiceImpl implements ClasService{
    
    
    @Autowired
    private ClasRepository clasRepository;    
    
    @Override
    public Clas create(Clas c) {
        return clasRepository.save(c);
    }

    @Override
    public Clas get(Integer classId) {
        return clasRepository.findOne(classId);
    }

    @Override
    public List<Clas> getAll() {
        return clasRepository.findAll();
    }

    @Override
    public boolean exists(Integer classId) {
        return clasRepository.exists(classId);
    }
    
}
