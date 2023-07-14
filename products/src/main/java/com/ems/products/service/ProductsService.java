package com.ems.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ems.products.entity.Product;
import com.ems.products.repository.ProductsRepository;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private MongoTemplate MongoTemplate;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public void deleteAllProducts() {
        repository.deleteAll();
    }

    public String addProduct(@RequestBody Product product) {
        product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
        System.out.println(product.getId());
        repository.save(product);
        return "Product added successfully";
    }

    public String updateProduct(String id, Product product) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        List<Product> existingProductList = MongoTemplate.find(query, Product.class);
        Product existingProduct = existingProductList.get(0);
        existingProduct.setName(product.getName());
        existingProduct.setCode(product.getCode());
        // repository.deleteById(id);
        repository.save(product);
        // addProduct(product);
        return "Product updated successfully";
    }

    public String deleteProduct(String id) {
        repository.deleteById(id);
        return "Product deleted successfully";
    }

}
