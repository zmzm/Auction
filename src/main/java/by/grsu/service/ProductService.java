package by.grsu.service;

import by.grsu.model.Product;

import java.util.List;

public interface ProductService {
    public Integer create(Product product);
    public Boolean delete(int id);
    public List<Product> findAll();
    public Boolean update(Product product);
    public Product findById(int id);
}
