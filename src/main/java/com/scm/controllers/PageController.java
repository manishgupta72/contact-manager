package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {

        System.out.println("Home Page");
        // sending data to view
        model.addAttribute("name", "This is our Homa Page !");
        model.addAttribute("youtube", "learn anything from youtube in one place");
        model.addAttribute("githubrepo", "https://github.com/manishgupta72");
        return "home";

    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {

        System.out.println("About page loading");
        model.addAttribute("isLogin", false);
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage() {

        System.out.println("services page loading");
        return "services";
    }

}
