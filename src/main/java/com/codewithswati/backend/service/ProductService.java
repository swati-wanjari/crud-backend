package com.codewithswati.backend.service;

import com.codewithswati.backend.exception.ProductNotFoundException;
import com.codewithswati.backend.model.Product;
import com.codewithswati.backend.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> subjects = new ArrayList<>();
        productRepository.findAll().forEach(subjects::add);
        return subjects;
    }

    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException(id));
    }

    public Product updateProduct(Product newProduct) {
        Long id = newProduct.getId();
        return productRepository.findById(id)
                .map(user ->{
                    user.setUsername(newProduct.getUsername());
                    user.setName(newProduct.getName());
                    user.setEmail(newProduct.getEmail());

                    return productRepository.save(user);
                }).orElseThrow(()-> new ProductNotFoundException(id));

    }

    public String DeleteProduct(Long id) {
        if(!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        return "User with id "+id+" has been deleted successfully.";
    }
}
