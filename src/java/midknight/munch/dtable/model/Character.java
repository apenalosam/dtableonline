/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import midknight.munch.dtable.util.Util;

/**
 *
 * @author KODE
 */
@Entity
@Table(name="characters")
public class Character implements Serializable{
    @Id
    @Column(name="character_id")
    private int characterId;
    @Column(name="username")
    private String username;
    @Column(name="character_name")
    private String characterName;
    @Column(name="player_name")
    private String playerName;
    @Column(name="class_id")
    private int classId;
    @Column(name="lvl")
    private int lvl;
    @Column(name="race_id")
    private int raceId;
    @Column(name="campaign_id")
    private int campaignId;
    @Column(name="added_str")
    private int str;
    @Column(name="added_dex")
    private int dex;
    @Column(name="added_con")
    private int con;
    @Column(name="added_int")
    private int intl;
    @Column(name="added_wis")
    private int wis;
    @Column(name="added_cha")
    private int cha;
    @Column(name="exp_points")
    private int expPoints;
    @Column(name="creation_date")
    private Calendar creationDate;
    @Column(name="align_id")
    private int alignId;
    @Column(name="cp")
    private int cp;
    @Column(name="sp")
    private int sp;
    @Column(name="gp")
    private int gp;
    @Column(name="pp")
    private int pp;
    @Column(name="weapons")
    private String weapons;
    @Column(name="armors")
    private String armors;
    @Column(name="items")
    private String items;
    @Column(name="others")
    private String others;
    @Column(name="current_hp")
    private int currentHp;

    public Character() {
    }

    public Character(HttpServletRequest request) {
        this.characterId = Integer.parseInt(request.getParameter("characterId"));
        this.characterName = Util.decode(request.getParameter("characterName"));
        this.playerName = Util.decode(request.getParameter("playerName"));
        this.classId = Integer.parseInt(request.getParameter("classId"));
        this.campaignId = Integer.parseInt(request.getParameter("campaignId"));
        this.lvl = Integer.parseInt(request.getParameter("lvl"));
        this.str = Integer.parseInt(request.getParameter("str"));
        this.dex = Integer.parseInt(request.getParameter("dex"));
        this.con = Integer.parseInt(request.getParameter("con"));
        this.intl = Integer.parseInt(request.getParameter("intl"));
        this.wis = Integer.parseInt(request.getParameter("wis"));
        this.cha = Integer.parseInt(request.getParameter("cha"));
        this.alignId = Integer.parseInt(request.getParameter("alignId"));
        this.expPoints = Integer.parseInt(request.getParameter("expPoints"));
        this.raceId = Integer.parseInt(request.getParameter("raceId"));
        this.cp = Integer.parseInt(request.getParameter("cp"));
        this.sp = Integer.parseInt(request.getParameter("sp"));
        this.gp = Integer.parseInt(request.getParameter("gp"));
        this.pp = Integer.parseInt(request.getParameter("pp"));
        this.weapons = Util.decode(request.getParameter("weapons"));
        this.armors = Util.decode(request.getParameter("armors"));
        this.items = Util.decode(request.getParameter("items"));
        this.others = Util.decode(request.getParameter("others"));
    }

    public Character update(Character chara){
        this.alignId = chara.getAlignId();
        this.campaignId = chara.getCampaignId();
        this.cha = chara.getCha();
        this.characterId = chara.getCharacterId();
        this.characterName = chara.getCharacterName();
        this.classId = chara.getClassId();
        this.con = chara.getCon();
        this.creationDate = chara.getCreationDate();
        this.dex = chara.getDex();
        this.expPoints = chara.getExpPoints();
        this.intl = chara.getIntl();
        this.lvl = chara.getLvl();
        this.playerName = chara.getPlayerName();
        this.raceId = chara.getRaceId();
        this.str = chara.getStr();
        this.username = chara.getUsername();
        this.wis = chara.getWis();
        this.cp = chara.getCp();
        this.sp = chara.getSp();
        this.gp = chara.getGp();
        this.pp = chara.getPp();
        this.weapons = chara.getWeapons();
        this.armors = chara.getArmors();
        this.items = chara.getItems();
        this.others = chara.getOthers();
        this.currentHp = chara.getCurrentHp();
        return this;
    }
    
    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public String getWeapons() {
        return weapons;
    }

    public void setWeapons(String weapons) {
        this.weapons = weapons;
    }

    public String getArmors() {
        return armors;
    }

    public void setArmors(String armors) {
        this.armors = armors;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getIntl() {
        return intl;
    }

    public void setIntl(int intl) {
        this.intl = intl;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(int expPoints) {
        this.expPoints = expPoints;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public int getAlignId() {
        return alignId;
    }

    public void setAlignId(int alignId) {
        this.alignId = alignId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "Character{" + "characterId=" + characterId + ", username=" + username + ", characterName=" + characterName + ", classId=" + classId + ", lvl=" + lvl + ", raceId=" + raceId + ", campaignId=" + campaignId + ", str=" + str + ", dex=" + dex + ", con=" + con + ", intl=" + intl + ", wis=" + wis + ", cha=" + cha + ", expPoints=" + expPoints + ", creationDate=" + creationDate + ", alignId=" + alignId + '}';
    }
    
}
