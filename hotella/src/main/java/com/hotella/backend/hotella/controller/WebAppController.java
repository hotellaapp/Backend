package com.hotella.backend.hotella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {

    private String appMode;


    @RequestMapping("/")
    public String index(Model model) {

        return "index";
    }

    @RequestMapping("/Hotel")
    public String hotelPage(Model model) {

        return "index";
    }

}