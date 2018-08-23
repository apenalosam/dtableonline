/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Vehicle;
import midknight.munch.dtable.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KODE
 */
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
    
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle create(Vehicle v) {
        return vehicleRepository.save(v);
    }

    @Override
    public Vehicle get(Integer id) {
        return vehicleRepository.findOne(id);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getByType(String type) {
        return vehicleRepository.findByType(type);
    }

    @Override
    public boolean exists(Integer id) {
        return vehicleRepository.exists(id);
    }
    
}
