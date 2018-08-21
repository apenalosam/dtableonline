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
@Table(name="alignments", schema="dunganddrag")
public class Align implements Serializable{
    @Id
    @Column(name="alignment_id")
    private int alignmentId;
    @Column(name="align_name")
    private String alignName;

    public Align(int alignmentId, String alignName) {
        this.alignmentId = alignmentId;
        this.alignName = alignName;
    }

    public Align() {
    }

    public int getAlignmentId() {
        return alignmentId;
    }

    public void setAlignmentId(int alignmentId) {
        this.alignmentId = alignmentId;
    }

    public String getAlignName() {
        return alignName;
    }

    public void setAlignName(String alignName) {
        this.alignName = alignName;
    }
    
}
