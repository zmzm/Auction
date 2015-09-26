package by.grsu.service;

import by.grsu.model.Role;

import java.util.List;

public interface RoleService {
    public Integer create(Role role);
    public Boolean delete(int id);
    public List<Role> findAll();
    public Boolean update(Role role);
    public Role findById(int id);
}
