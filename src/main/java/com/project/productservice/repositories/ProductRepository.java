package com.project.productservice.repositories;

import com.project.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {

    List<Product> findByTitleContaining(String word);

    Optional<Product> findById(Long id);

    Product save(Product product);
}
