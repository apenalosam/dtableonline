/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.User;
import midknight.munch.dtable.util.AccessMenu;

/**
 *
 * @author KODE
 */
public interface UserService {
    void create(User user);
    void save(User user, Long role);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    boolean exists(String username);
    
    List<AccessMenu> getAccessMenu(String username);
}
