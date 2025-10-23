package com.example.store_payment.Controllers;

import com.example.store_payment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.store_payment.Entities.Products;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class productController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/adding/products")
    public Products createProduct(@RequestBody Products product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/delete/products/{barCode}")
    public void deleteProduct(@PathVariable String barCode) {
        productRepository.deleteById(barCode);
    }

    @GetMapping("/get/products/{barCode}")
    public Products getProduct(@PathVariable String barCode) {
        return productRepository.findById(barCode).orElse(null);
    }

    @PutMapping("/update/products/{barCode}")
    public Products updateProduct(@PathVariable String barCode, @RequestBody Products product) {
        if (productRepository.existsById(barCode)) {
            product.setBarCode(barCode);
            return productRepository.save(product);
        } else {
            return null;
        }
    }
}
