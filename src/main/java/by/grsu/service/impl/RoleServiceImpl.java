package by.grsu.service.impl;

import by.grsu.model.Role;
import by.grsu.repository.RoleRepository;
import by.grsu.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public Integer create(Role role) {
        return roleRepository.save(role).id;
    }

    @Override
    @Transactional
    public Boolean delete(int id) {
        Role r = roleRepository.findOne(id);
        if (r == null) {
            return false;
        }
        roleRepository.delete(r);
        return true;
    }

    @Override
    @Transactional
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Boolean update(Role role) {
        Role r = roleRepository.findOne(role.id);
        if (r == null) {
            return false;
        }
        r.name = role.name;
        return true;
    }

    @Override
    @Transactional
    public Role findById(int id) {
        return roleRepository.findOne(id);
    }
}
