package com.codegenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nc
 */
@Controller
@RequestMapping(value = "generator/page")
public class GeneratorPageController {

    @RequestMapping(value = "home")
    public String home() {
        return "generator-page/generator-home";
    }



}
