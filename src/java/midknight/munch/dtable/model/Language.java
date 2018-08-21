/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author XMY6267
 */
@Entity
@Table(name="languages", schema="dunganddrag")
public class Language implements Serializable{
    @Id
    @Column(name="language_id")
    private int languageId;
    @Column(name="name")
    private String name;

    public Language() {
    }

    public Language(int languageId, String name) {
        this.languageId = languageId;
        this.name = name;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
