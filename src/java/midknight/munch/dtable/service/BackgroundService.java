/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Background;

/**
 *
 * @author KODE
 */
public abstract interface BackgroundService {
    public abstract Background get(Integer id);
    public abstract List<Background> getAll();
    public abstract boolean exists(Integer id);
    public abstract Background create(Background b);
}
