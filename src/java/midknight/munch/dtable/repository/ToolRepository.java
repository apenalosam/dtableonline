/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.repository;

import java.util.List;
import midknight.munch.dtable.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author XMY6267
 */
public interface ToolRepository extends JpaRepository<Tool, Integer>{
    public abstract List<Tool> findByToolType(Integer typeId);
}
