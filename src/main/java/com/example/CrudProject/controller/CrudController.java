package com.example.CrudProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class CrudController {

    public CrudController(){

    }

    @GetMapping(value="/")
    public ModelAndView index(){
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.setViewName("template.html");
        return mav;
    }

    @PostMapping(value="/login")
    public ModelAndView registerUsers(){
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.setViewName("template.html");
        return mav;
    }

    @PostMapping(value="/registerusers")
    public ModelAndView log(){
        var mav = new ModelAndView();
        mav.addObject("date", new Date(System.currentTimeMillis()));
        mav.setViewName("template.html");
        return mav;
    }
}
