package by.grsu.controller;

import by.grsu.model.Role;
import by.grsu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Role get(@PathVariable("id") Integer id){
        return roleService.findById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Role> getAll(){
        return roleService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Integer create(@RequestBody Role role){
        return roleService.create(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Boolean delete(@PathVariable("id") Integer id){
        return roleService.delete(id);
    }
}
