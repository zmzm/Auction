package by.grsu.controller;

import by.grsu.model.Product;
import by.grsu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Product get(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Product> getAll() {
        return productService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Integer create(@RequestBody Product product) {
        return productService.create(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") Integer id) {
        return productService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Boolean update(@RequestBody Product product) {
        return productService.update(product);
    }
}
