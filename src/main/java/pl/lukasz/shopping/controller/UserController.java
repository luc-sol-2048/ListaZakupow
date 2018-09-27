package pl.lukasz.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.shopping.repository.UserRepository;
import pl.lukasz.shopping.model.User;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;


//        @GetMapping("/show")
//       public List<User> show() {
//        return repository.findAll();
//    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());

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
}
