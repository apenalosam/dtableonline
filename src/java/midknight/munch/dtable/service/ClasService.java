/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Clas;

/**
 *
 * @author XMY6267
 */
public interface ClasService {
    public Clas create(Clas c);
    public Clas get(Integer classId);
    public List<Clas> getAll();
    public boolean exists(Integer classId);
}
