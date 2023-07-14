package com.ems.products.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String id;
    // private String cnt;
    private String name;
    private String code;

    public Product() {
    }

    public Product(String id, String name, String code) {
        // this.cnt = cnt;
        this.id = id;
        this.name = name;
        this.code = code;
    }

    // public String getId() {
    //     return this.cnt;
    // }

    // public void setId(String value) {
    //     this.cnt = value;
    // }

    public String getId() {
        return this.id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    // @Override
    // public String toString() {
    //     return "Employee [id=" + id + ", name=" + this.name + ", code=" + this.code + "]";
    // }

}
