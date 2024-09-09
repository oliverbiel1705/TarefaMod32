package com.mod32.service;

import com.mod32.model.entity.Product;
import com.mod32.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("\n *** Product " + id + " not found *** \n"));
    }
    public Product save(Product p) {
        return repository.save(p);
    }
    public Product update(Long id, Product p) {
        Product dbP = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("\n *** Product " + id + " not found *** \n"));
        dbP.setName(p.getName());
        dbP.setDescription(p.getDescription());
        return repository.save(dbP);
    }
    public void delete(Long id) {
        Product p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("\n *** Product " + id + " not found *** \n"));
        repository.delete(p);
    }
}
