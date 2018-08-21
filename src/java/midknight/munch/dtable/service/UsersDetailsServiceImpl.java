/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.HashSet;
import java.util.Set;
import midknight.munch.dtable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KODE
 */
public class UsersDetailsServiceImpl implements UserDetailsService{
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @Transactional(readOnly=true)
  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException
  {
    midknight.munch.dtable.model.User user = this.userRepository.findByUsername(username);
    Set<GrantedAuthority> grantedAuthorities = new HashSet();
    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword().trim()));
    return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
  }
}
