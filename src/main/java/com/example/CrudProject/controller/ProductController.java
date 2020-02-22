package com.example.CrudProject.controller;

import com.example.CrudProject.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.Normalizer;
import java.util.Date;
import java.util.Map;

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
    public String insertAction(HttpRequest httpRequest){
        return "teste";
    }
}
