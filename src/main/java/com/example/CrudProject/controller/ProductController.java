package com.example.CrudProject.controller;

import com.example.CrudProject.dto.ProductDto;
import com.example.CrudProject.entity.Product;
import com.example.CrudProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;

@RestController
public class ProductController {

    @Autowired
    private ITemplateEngine templateEngine;


    public ProductController(ITemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @GetMapping(value="/index/product")
    public String indexAction(){
        Context context = new Context();context.setVariable("date", new Date(System.currentTimeMillis()));
        return templateEngine.process("views/estoque/index.html", context);
    }

    @GetMapping(value="/new/product")
    public String newAction(){
        Context context = new Context();context.setVariable("date", new Date(System.currentTimeMillis()));
        return templateEngine.process("views/estoque/form.html", context);
    }

    @PostMapping(value="/insert/product")
    public String insertAction(Product product){
        System.out.println(product.getName());

        return product.toString();
    }
}
