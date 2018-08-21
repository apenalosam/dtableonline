/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.controller;

import java.security.Principal;
import org.jboss.logging.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author KODE
 */
@Controller
@RequestMapping(value="/master")
public class MasterController {
    
    private static final Logger logger = Logger.getLogger(MainController.class);
    
    @RequestMapping(value="/sheet_manager")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView sheetManager(Principal thisUser){
        ModelAndView mav = new ModelAndView("master/sheet_manager");
        return mav;
    }
}
