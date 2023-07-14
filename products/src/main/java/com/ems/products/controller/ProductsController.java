package com.ems.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.products.entity.Product;
import com.ems.products.service.ProductsService;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService service;
    // If our website recieves a get request with this link "/". then getProducts function is executed.
    @GetMapping("/")
    public String getProducts(Model model) {
        List<Product> products = service.getProducts();
        // copy the list of products into products(can rename the first argument of addAttribute function) and goes to the home.html.
        model.addAttribute("products", products);
        // return home.html file.
        return "home";
    }

    @GetMapping("/add")
    public String getProduct(Model model) {
        model.addAttribute("products", new Product());
        return "add";
    }

    @PostMapping("/")
    public String addProduct(@ModelAttribute("Product") Product product) {
        service.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String getUpdatedProduct(@PathVariable String id) {
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable String id, @ModelAttribute("Product") Product product) {
        service.updateProduct(id, product);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
        return "redirect:/";
    }

}