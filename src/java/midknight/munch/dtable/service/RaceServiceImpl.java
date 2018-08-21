/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import midknight.munch.dtable.model.Race;
import midknight.munch.dtable.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XMY6267
 */
@Service
@Transactional
public class RaceServiceImpl implements RaceService{
    
    @Autowired
    private RaceRepository raceRepository;

    @Override
    public Race create(Race r) {
        return raceRepository.save(r);
    }

    @Override
    public Race get(Integer raceId) {
        return raceRepository.findOne(raceId);
    }

    @Override
    public List<Race> findAll() {
        return raceRepository.findAll();
    }

    @Override
    public boolean exists(Integer raceId) {
        return raceRepository.exists(raceId);
    }

    @Override
    public Race getByName(String raceName) {
        return raceRepository.findByRaceName(raceName);
    }
    
}
