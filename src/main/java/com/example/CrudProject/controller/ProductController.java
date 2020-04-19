package com.example.CrudProject.controller;

import com.example.CrudProject.entity.Product;
import com.example.CrudProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ITemplateEngine templateEngine;

    private ProductRepository productRepository;

    public ProductController(ITemplateEngine templateEngine, ProductRepository productRepository) {
        this.templateEngine = templateEngine;
        this.productRepository = productRepository;
    }

    @RequestMapping(value="/index/product")
    public ModelAndView indexAction(){
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.addObject("products", productRepository.findAll());
        mav.setViewName("views/estoque/index.html");
        return mav;
    }

    @RequestMapping(value="/new/product")
    public ModelAndView newAction(){
        var mav = new ModelAndView();
        mav.setViewName("views/estoque/form.html");
        return mav;
    }

    @PostMapping(value="/insert/product")
    public String insertAction(Product product){
        productRepository.save(product);
        return "redirect:/index/product";

    }

    @GetMapping(value="/index/product/detail/{id}")
    public ModelAndView detailAction(@PathVariable(value = "id") Long id){
        Optional<Product> product =  productRepository.findById(id);;
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.addObject("products", product.get());
        mav.setViewName("views/estoque/view.html");
        return mav;
    }

    @GetMapping(value="/index/product/edit/{id}")
    public ModelAndView editAction(@PathVariable(value = "id") Long id){
        Optional<Product> product =  productRepository.findById(id);
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.addObject("products", product.get());
        mav.setViewName("views/estoque/form.html");
        return mav;
    }

    @GetMapping(value="/product/delete")
    public String deleteAction(){
        Context context = new Context();context.setVariable("date", new Date(System.currentTimeMillis()));
        return "ainda nao fiz o delete";
    }
}
