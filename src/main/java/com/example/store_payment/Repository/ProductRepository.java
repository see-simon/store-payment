package com.example.store_payment.Repository;
import com.example.store_payment.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
