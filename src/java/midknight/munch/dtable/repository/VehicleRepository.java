/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.repository;

import java.util.List;
import midknight.munch.dtable.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author KODE
 */
public abstract interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
    public abstract List<Vehicle> findByType(String type);
}
