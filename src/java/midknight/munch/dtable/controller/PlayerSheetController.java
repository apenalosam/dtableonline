/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.controller;

import java.security.Principal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import midknight.munch.dtable.model.Align;
import midknight.munch.dtable.model.Background;
import midknight.munch.dtable.model.User;
import midknight.munch.dtable.model.Character;
import midknight.munch.dtable.model.Clas;
import midknight.munch.dtable.model.Race;
import midknight.munch.dtable.service.AlignService;
import midknight.munch.dtable.service.BackgroundService;
import midknight.munch.dtable.service.CharacterService;
import midknight.munch.dtable.service.ClasService;
import midknight.munch.dtable.service.RaceService;
import midknight.munch.dtable.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value="/dtable")
public class PlayerSheetController {
    
    @PersistenceContext
    EntityManager entityManager;
    private static final Logger logger = Logger.getLogger(MainController.class);
    
    @Autowired
    UserService userService;
    @Autowired
    CharacterService characterService;
    @Autowired
    ClasService clasService;
    @Autowired
    AlignService alignService;
    @Autowired
    RaceService raceService;
    @Autowired
    BackgroundService backgroundService;
    
    @RequestMapping(value="/player_sheet/{characterId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView SheetDisplay(Principal thisUser, @PathVariable int characterId){
        ModelAndView mav = new ModelAndView("dtable/player_sheet"); 
        System.out.println("MAV created");
        Character character = characterService.get(characterId);
        System.out.println("Character created: "+character.getCharacterName());
        mav.addObject("c", character);
        System.out.println(character.getCharacterName()+" added to MAV");
        User user = userService.findByUsername(thisUser.getName());  
        System.out.println("User created");
        mav.addObject("user", user);
        System.out.println(user.getNames()+" added to MAV");
        Clas clas = clasService.get(character.getClassId());
        System.out.println("Class fetched");
        mav.addObject("cl", clas);
        System.out.println("Class added to MAV");
        List<Clas> selectClas = clasService.getAll();
        System.out.println("List of classes fetched");
        mav.addObject("classes", selectClas);
        System.out.println("List of classes added to MAV");
        Align align = alignService.get(character.getAlignId());
        List<Align> alignments = alignService.findAll();
        Race race = raceService.get(character.getRaceId());
        List<Race> races = raceService.findAll();
        List<Background> backgrounds = backgroundService.getAll();
        int profBonus;
        StringBuilder sql = new StringBuilder("SELECT prof_bonus FROM dunganddrag.class_abilities ");
        sql.append("WHERE (class_id = ").append(clas.getClassId());
        sql.append(" AND lvl = ").append(character.getLvl()).append(");");
        System.out.println(sql.toString());
        profBonus = (int) entityManager.createNativeQuery(sql.toString()).getResultList().get(0);
        System.out.println(profBonus);
        mav.addObject("r", race);
        mav.addObject("races", races);
        mav.addObject("al", align);
        mav.addObject("alignments", alignments);
        mav.addObject("backgrounds", backgrounds);
        mav.addObject("menu", this.userService.getAccessMenu(user.getUsername()));
        mav.addObject("btnName", "Update");
        mav.addObject("isNew", false);
        mav.addObject("profBonus", profBonus);
        return mav;
    }    
    @RequestMapping(value="/new_sheet", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView newSheet (Principal thisUser){
        ModelAndView mav = new ModelAndView("dtable/player_sheet");
        User user = this.userService.findByUsername(thisUser.getName());
        Character c = new Character();
        Clas clas = new Clas();
        Race race = new Race();
        Align alignment = new Align();
        List<Clas> selectClas = clasService.getAll();
        List<Align> alignments = alignService.findAll();
        List<Race> races = raceService.findAll();
        List<Background> backgrounds = backgroundService.getAll();
        mav.addObject("races", races);
        mav.addObject("backgrounds", backgrounds);
        mav.addObject("alignments", alignments);
        mav.addObject("user", user);
        mav.addObject("c", c);
        mav.addObject("cl", clas);
        mav.addObject("classes", selectClas);
        mav.addObject("r", race);
        mav.addObject("al", alignment);
        mav.addObject("menu", this.userService.getAccessMenu(user.getUsername()));
        mav.addObject("btnName", "Save");
        mav.addObject("isNew", true);
        mav.addObject("speedDescription", "R = Regular speed\nH = Speed while wearing heavy armor\nS = Swimming speed\nF = Flying speed");
        return mav;
    }
    
    @RequestMapping(value="/getRace/{raceId}", method = {RequestMethod.POST})
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody Race refreshRace(@PathVariable int raceId){
        Race race = raceService.get(raceId);
        return race;
    }
    
    @RequestMapping(value="/getClas/{clasId}", method = {RequestMethod.POST})
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody Clas refreshClas(@PathVariable int clasId){
        Clas clas = clasService.get(clasId);
        return clas;
    }
    
    @RequestMapping(value="/getAlign/{alignmentId}", method = {RequestMethod.POST})
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody Align refreshAlign(@PathVariable int alignmentId){
        Align align = alignService.get(alignmentId);
        return align;
    }
    
    @RequestMapping(value="/save_sheet", method = {RequestMethod.POST})
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    ModelAndView saveSheet(Principal thisUser, HttpServletRequest request) {
        ModelAndView mav;
        String message;
        try {
            Character character = new Character(request);
            character.setUsername(userService.findByUsername(thisUser.getName()).getUsername());
            if(characterService.exists(character.getCharacterId())){
                character = characterService.update(character);
            }
            else{
                character = characterService.create(character);
            }
            mav = new ModelAndView("dtable/player_sheet");
            mav.addObject("c", character);
            message = "Character has been saved correctly";
        }
        catch(Exception e){
            mav = new ModelAndView("error");
            message = "An error occured: " + e.getMessage();
            System.out.println(e);
        }
        mav.addObject("msg", message);
        return mav;
    }   
    
    @RequestMapping(value="/character_selector", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    String selectCharacter (Principal thisUser){
        User user = userService.findByUsername(thisUser.getName());
        List<Object> listByUsername;
        StringBuilder result = new StringBuilder();
        try{
            listByUsername = characterService.showCharacters(user.getUsername());
            String tmp;
            for(Object o: listByUsername){
                tmp = o.toString();
                result.append("<tr>");
                String[] items = tmp.split(", ");
                for(String s: items){
                    if(s.startsWith("<td>")){
                        result.append(s);
                    }
                    else{
                        if(s.startsWith("["))
                            s = s.substring(1);
                        result.append("<td class=\"text-center\">").append(s).append("</td>");
                    }
                }
                result.append("</tr>");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return result.toString();
    }
}
