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
 * @author XMY6267
 */
public abstract interface BackgroundService {
    public Background create(Background b);
    public Background get(Integer id);
    public List<Background> getAll();
    public boolean exists(Integer id);
}
