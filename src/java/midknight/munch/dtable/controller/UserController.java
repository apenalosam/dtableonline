/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import midknight.munch.dtable.model.User;
import midknight.munch.dtable.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author KODE
 */
@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/login"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Your session has been closed successfully.");
        }
        model.addAttribute("login", "1");
        return "login";
    }
    
    @RequestMapping(value = {"/", "/welcome"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView welcome(Model model, Principal user) {
        logger.info("Main page");
        ModelAndView mav = new ModelAndView("index");
        User loggedUser = this.userService.findByUsername(user.getName());
        System.out.println("Username for logged user: " + loggedUser.getUsername());
        System.out.println("Name of logged user: " + loggedUser.getNames() + " " + loggedUser.getLastNames());
        mav.addObject("user", loggedUser);
        mav.addObject("menu", this.userService.getAccessMenu(loggedUser.getUsername()));
        return mav;
    }
    
    @RequestMapping(value="/register")
    public ModelAndView registerPage(){
        ModelAndView mav = new ModelAndView("register");
        return mav;
    }
    @RequestMapping(value="/exists/{username}", method = {RequestMethod.POST})
    public @ResponseBody 
    String userExists(@PathVariable String username){
        String msg = null;
        if(userService.exists(username)){
            msg = "That username is already in use.";
        }
        return msg;
    }
    
    @RequestMapping(value={"/register_user"},  method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    public @ResponseBody 
    ModelAndView registerUser(HttpServletRequest request){
        String message;
        ModelAndView mav;
        try {            
            User u = new User(request);            
            System.out.println(u.getUsername());
            if (userService.exists(u.getUsername())) {
                mav = new ModelAndView("register");
                message = "That username is already in use";
                mav.addObject("msg", message);
                mav.addObject("username", u.getUsername());
                mav.addObject("pswd", u.getPassword());
                mav.addObject("pswdConfirm", u.getPassword());
                mav.addObject("names", u.getNames());
                mav.addObject("lastNames", u.getLastNames());
            } else {
                mav = new ModelAndView("login");
                userService.create(u);
                message = "Account created successfully";
                mav.addObject("msg", message);
            }
        } catch (Exception e) {
            mav = new ModelAndView("register");
            message = "Could not finish operation: " + e.getMessage();
            System.out.println(e);
            mav.addObject("msg", message);
        }
        return mav;
    }
}
