/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midknight.munch.dtable.service;

import java.util.List;
import midknight.munch.dtable.model.Tool;
import midknight.munch.dtable.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XMY6267
 */
@Service
@Transactional
public class ToolServiceImpl implements ToolService{
    @Autowired
    ToolRepository toolRepository;

    @Override
    public Tool create(Tool t) {
        return toolRepository.save(t);
    }

    @Override
    public Tool get(Integer id) {
        return toolRepository.findOne(id);
    }

    @Override
    public List<Tool> getAll() {
        return toolRepository.findAll();
    }

    @Override
    public List<Tool> getByType(Integer type) {
        return toolRepository.findByToolType(type);
    }

    @Override
    public boolean exists(Integer id) {
        return toolRepository.exists(id);
    }
}
