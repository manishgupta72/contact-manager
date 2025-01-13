package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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

    @RequestMapping("/contact")
    public String contactPage() {

        System.out.println("contact page loading");
        return "contact";
    }

    @RequestMapping("/login")
    public String loginPage() {

        System.out.println("login page loading");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {

        UserForm userForm = new UserForm();
       userForm.setName("manish");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing register

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, Model model) {
        System.out.println(userForm);

        if (userForm.getEmail() == null || userForm.getEmail().isEmpty()) {
            model.addAttribute("error", "Email cannot be null or empty");
            return "register";
        }

        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .about(userForm.getAbout())
                .phoneNumber(userForm.getPhoneNumber())
                .profilePic("https://avatar.iran.liara.run/public/19")
                .build();

        User savedUser = userService.saveUser(user);
        System.out.println("User saved successfully");
        // save data into database

        // user service
        // redirecting to login page
        return "redirect:/login";
    }
}
