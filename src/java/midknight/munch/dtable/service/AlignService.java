/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Align;
/**
 *
 * @author XMY6267
 */
public interface AlignService {
    public Align get(Integer alignId);
    public List<Align> findAll();
}
