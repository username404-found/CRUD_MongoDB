package com.ems.products.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ems.products.entity.Product;

public interface ProductsRepository extends MongoRepository<Product, String> {

    public void deleteById(BigInteger id);

}
