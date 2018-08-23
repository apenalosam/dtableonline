/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Vehicle;

/**
 *
 * @author KODE
 */
public interface VehicleService {
    public Vehicle create(Vehicle v);
    public Vehicle get(Integer id);
    public List<Vehicle> getAll();
    public List<Vehicle> getByType(String type);
    public boolean exists(Integer id);
}
