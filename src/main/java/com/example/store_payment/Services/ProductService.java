package com.example.store_payment.Services;
import com.example.store_payment.Entities.Products;
import com.example.store_payment.Repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Products save(Products product) {
        return productRepository.save(product);
    }

    public void deleteById(String barCode) {
        productRepository.deleteById(barCode);
    }

    public Products getAllProducts() {
        return (Products) productRepository.findAll();
    }

    public Products findById(String barCode) {
        return productRepository.findById(barCode).orElse(null);
    }

    public Products update(String barCode, Products product) {
        if (productRepository.existsById(barCode)) {
            product.setBarCode(barCode);
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public boolean existsById(String barCode) {
        return productRepository.existsById(barCode);
    }

}
