package by.grsu.service.impl;

import by.grsu.model.Product;
import by.grsu.repository.ProductRepository;
import by.grsu.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductRepository productRepository;
    private List<String> types = new ArrayList<>();

    @Override
    public Integer create(Product product) {
        return productRepository.save(product).getId();
    }

    @Override
    public Boolean delete(int id) {
        Product p = productRepository.findOne(id);
        if (p == null) {
            return false;
        }
        productRepository.delete(p);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Boolean update(Product product) {
        Product p = productRepository.findOne(product.getId());
        if (p == null) {
            return false;
        }
        //Integer count = p.getAvailableCount() - (product.getInitialCount() - product.getAvailableCount());
        //p.setAvailableCount(count);
        p.setTitle(product.getTitle());
        p.setPrice(product.getPrice());
        return true;

    }

    @Override
    public Product findById(int id) {
        Product p = productRepository.findOne(id);
        if (p == null) {
            return p;
        }
        return p;
    }

    @Override
    public List<String> getProductTypes() {
        List<Product> products = productRepository.findAll();
        for(int i = 0; i < products.size(); i ++){
            types.add(products.get(i).getTitle());
        }
        return types;
    }
}
