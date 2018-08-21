/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.controller;

import java.security.Principal;
import midknight.munch.dtable.model.User;
import midknight.munch.dtable.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    private static final Logger logger = Logger.getLogger(MainController.class);
    
    @Autowired
    private UserService userService;
    @RequestMapping(value={"/index", "index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public ModelAndView homePage(Principal user)
    {
        ModelAndView mav = new ModelAndView("index");
        User loggedUser = this.userService.findByUsername(user.getName());
        mav.addObject("user", loggedUser);
        mav.addObject("menu", this.userService.getAccessMenu(loggedUser.getUsername()));
        return mav;
    }
}
