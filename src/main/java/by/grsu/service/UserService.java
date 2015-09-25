package by.grsu.service;

import by.grsu.model.User;

import java.util.List;

public interface UserService {
    public Integer create(User user);
    public Boolean delete(int id);
    public List<User> findAll();
    public Boolean update(User user);
    public User findById(int id);
}
