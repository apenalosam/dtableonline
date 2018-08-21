/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import midknight.munch.dtable.model.Align;
import midknight.munch.dtable.repository.AlignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XMY6267
 */
@Service
@Transactional
public class AlignServiceImpl implements AlignService{

    @Autowired
    private AlignRepository alignRepository;
    @Override
    public Align get(Integer alignId) {
        return alignRepository.findOne(alignId);
    }

    @Override
    public List<Align> findAll() {
        return alignRepository.findAll();
    }
    
}
