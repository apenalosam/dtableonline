/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.repository;

import midknight.munch.dtable.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author XMY6267
 */
public abstract interface RaceRepository extends JpaRepository<Race, Integer>{
    public abstract Race findByRaceName(String raceName);
}
