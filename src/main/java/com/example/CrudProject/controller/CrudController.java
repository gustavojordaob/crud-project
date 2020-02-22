package com.example.CrudProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;

@RestController
public class CrudController {


    @Autowired
    private ITemplateEngine templateEngine;

    public CrudController(ITemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @GetMapping(value="/")
    public String index(){
        Context context = new Context();context.setVariable("date", new Date(System.currentTimeMillis()));
        return templateEngine.process("template.html", context);
    }

    @PostMapping(value="/login")
    public String registerUsers(){
        Context context = new Context();context.setVariable("date", new Date(System.currentTimeMillis()));
        return templateEngine.process("template.html", context);
    }

    @PostMapping(value="/registerusers")
    public String log(){
        Context context = new Context();context.setVariable("date", new Date(System.currentTimeMillis()));
        return templateEngine.process("template.html", context);
    }
}
