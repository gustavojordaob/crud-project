package com.example.CrudProject.controller;

import com.example.CrudProject.entity.Product;
import com.example.CrudProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ITemplateEngine templateEngine;

    private ProductRepository productRepository;


    public ProductController(ITemplateEngine templateEngine, ProductRepository productRepository) {
        this.templateEngine = templateEngine;
        this.productRepository = productRepository;
    }

    @GetMapping(value="/index/product")
    public String indexAction(){
        Context context = new Context();
        context.setVariable("date", new Date(System.currentTimeMillis()));
        context.setVariable("products",productRepository.findAll());
        return templateEngine.process("views/estoque/index.html", context);
    }

    @GetMapping(value="/new/product")
    public String newAction(){
        Context context = new Context();
        context.setVariable("date", new Date(System.currentTimeMillis()));
        context.setVariable("products",productRepository.findAll());
        return templateEngine.process("views/estoque/form.html", context);
    }

    @PostMapping(value="/insert/product")
    public String insertAction(Product product){
        productRepository.save(product);
        return "deu certo porra!";
    }

    @GetMapping(value="/index/product/detail/{id}")
    public String detailAction(@PathVariable(value = "id") Long id){
        Context context = new Context();
        System.out.println(productRepository.findById(id));
        Optional<Product> product =  productRepository.findById(id);;

        context.setVariable("date", new Date(System.currentTimeMillis()));
        context.setVariable("products", productRepository.findById(id));
        return templateEngine.process("views/estoque/view.html", context);
    }

    @GetMapping(value="/product/edit")
    public String editAction(){
        Context context = new Context();context.setVariable("date", new Date(System.currentTimeMillis()));
        return templateEngine.process("views/estoque/form.html", context);
    }

    @GetMapping(value="/product/delete")
    public String deleteAction(){
        Context context = new Context();context.setVariable("date", new Date(System.currentTimeMillis()));
        return "ainda nao fiz o delete";
    }
}
