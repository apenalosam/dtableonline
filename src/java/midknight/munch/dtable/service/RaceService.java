/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Race;

/**
 *
 * @author XMY6267
 */
public interface RaceService {
    public Race create(Race r);
    public Race get(Integer raceId);
    public List<Race> findAll();
    public boolean exists(Integer raceId);
    public Race getByName(String raceName);
}
