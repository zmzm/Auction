package by.grsu.controller;

import by.grsu.model.User;
import by.grsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody User get(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Integer create(@RequestBody User user){
        return userService.create(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") Integer id){
        return userService.delete(id);
    }
}
