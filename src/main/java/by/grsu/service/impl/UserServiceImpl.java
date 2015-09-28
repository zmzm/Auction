package by.grsu.service.impl;

import by.grsu.model.User;
import by.grsu.repository.UserRepository;
import by.grsu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    @Transactional
    public Integer create(User user) {
        return userRepository.save(user).id;
    }

    @Override
    @Transactional
    public Boolean delete(int id) {
        User u = userRepository.findOne(id);
        if(u == null){
            return false;
        }
        userRepository.delete(u);
        return true;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Boolean update(User user) {
        User u = userRepository.findOne(user.id);
        if(u == null){
            return false;
        }
        u.name = user.name;
        u.password = user.password;
        u.role = user.role;
        return true;
    }

    @Override
    @Transactional
    public User findById(int id) {
        User u = userRepository.findOne(id);
        if(u == null){
            return u;
        }
        return u;
    }
}
