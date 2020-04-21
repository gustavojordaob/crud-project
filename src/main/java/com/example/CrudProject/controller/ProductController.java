package com.example.CrudProject.controller;

import com.example.CrudProject.entity.Product;
import com.example.CrudProject.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import java.util.Date;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value="/index/product")
    public ModelAndView indexAction(ServletRequest request){

        if(request.getParameter("search") != null){
            Long id = Long.valueOf(request.getParameter("search"));
            System.out.println(id);

            var mav = new ModelAndView();
            mav.addObject("date", new Date(System.currentTimeMillis()));
            mav.addObject("products", productRepository.findById(id).get());
            mav.setViewName("views/estoque/index.html");
            return mav;
        }

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

    @RequestMapping(value="/insert/product")
    public String insertAction(Product product){
        productRepository.save(product);
        return "redirect:/index/product";

    }

    @RequestMapping(value="/product/detail/{id}")
    public ModelAndView detailAction(@PathVariable(value = "id") Long id){
        Optional<Product> product =  productRepository.findById(id);;
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.addObject("products", product.get());
        mav.setViewName("views/estoque/view.html");
        return mav;
    }

    @RequestMapping(value="/product/edit/{id}")
    public ModelAndView editAction(@PathVariable(value = "id") Long id){
        Optional<Product> product =  productRepository.findById(id);
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.addObject("products", product.get());
        mav.setViewName("views/estoque/form.html");
        return mav;
    }

    @GetMapping(value="/product/delete/{id}")
    public String deleteAction(@PathVariable(value = "id") Long id){
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
        return "redirect:/index/product";
    }

    @RequestMapping(value="/index/filter/{value}")
    public ModelAndView filter(@PathVariable(value = "value") String value){
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.addObject("products", productRepository.findAll());
        mav.setViewName("views/estoque/index.html");
        return mav;
    }
}
