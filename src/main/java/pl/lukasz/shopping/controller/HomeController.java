package pl.lukasz.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lukasz.shopping.model.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("user",new User());
        return "index";
       }
    @GetMapping("/home")
    public String userHomePage(){
        return "home";
    }


    @RequestMapping("/-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "index";
    }

    @RequestMapping("/-register")
    public String registerError(Model model) {
        model.addAttribute("registerError", true);
        return "index";
    }


}
