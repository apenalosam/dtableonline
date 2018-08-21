/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import midknight.munch.dtable.model.User;
import midknight.munch.dtable.repository.UserRepository;
import midknight.munch.dtable.util.AccessMenu;
import midknight.munch.dtable.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KODE
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(User user, Long role){
        userRepository.saveAndFlush(user);
    }
    
    @Override
    public void create(User user){
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    
    @Override
    public boolean exists(String username){
        return userRepository.exists(username);
    }

    @Override
    public List<AccessMenu> getAccessMenu(String username) {
        List<AccessMenu> menu = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT m.menu_name, m.link, m.icon ");
        sql.append("FROM access_menu AS am INNER JOIN ");
        sql.append("menu AS m ON am.menu_id = m.menu_id ");
        sql.append("WHERE am.username = '");
        sql.append(username).append("';");
        try {
            List<Object[]> datos = entityManager.createNativeQuery(sql.toString()).getResultList();
            AccessMenu m;
            for (Object[] d : datos) {
                m = new AccessMenu();
                m.setMenuName(Util.getStringValue(d[0]));
                m.setLink(Util.getStringValue(d[1]));
                m.setIcon(Util.getStringValue(d[2]));
                menu.add(m);
            }
        } catch (Exception e) {
            Throwable realCause = e.getCause();
            if (realCause.getMessage().contains("could not extract ResultSet")) {
                System.out.println("Either the Database or the table does not exist!");
            } else {
                System.out.println("Error1 e : " + realCause);
            }
        }
        return menu;
    }
}
