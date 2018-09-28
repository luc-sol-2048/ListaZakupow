package pl.lukasz.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.shopping.repository.UserRepository;
import pl.lukasz.shopping.model.User;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserRepository repository;



    @PostMapping("/login")
    public String login(@ModelAttribute User user) {


        String email = user.getEmail();
        User db = repository.findByEmail(email);

        if (db==null) {
            return "redirect:/?error=true";

        }
        if (user.getPassword().equals(db.getPassword())) {

            return "home";
        } else {
            return "redirect:/?error=true";
        }
    }


    @PostMapping("/user/add")
    public String register(@Valid @ModelAttribute User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "redirect:/";
        }
        else {

            try {
                repository.save(user);
            }catch (Exception e){
                e.printStackTrace();
                return "redirect:/?register=true";
            }

            return "home";
        }
    }
}
