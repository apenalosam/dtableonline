/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Tool;

/**
 *
 * @author XMY6267
 */
public interface ToolService {
    public Tool create(Tool t);
    public Tool get(Integer id);
    public List<Tool> getAll();
    public List<Tool> getByType(Integer type);
    public boolean exists(Integer id);
}
