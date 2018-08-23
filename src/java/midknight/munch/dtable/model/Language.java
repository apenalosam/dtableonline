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
    private int id;
    @Column(name="language_name")
    private String name;
    @Column(name="language_type")
    private int type;
    @Column(name="language_script")
    private String script;

    public Language() {
    }

    public Language(int id, String name, int type, String script) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.script = script;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
    
    
}
