package pl.maslowskis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.maslowskis.entity.User;
import pl.maslowskis.entity.request.AddUserRequest;
import pl.maslowskis.repository.UserRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by oro-6 on 3/12/2018.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;


    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ModelAndView getAllUsers(Model model) {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("hello.html");
       modelAndView.addObject("dupa", "dupa");

       return modelAndView;
    }

    @PostMapping
    public void addUser(@RequestBody AddUserRequest addUserRequest)
    {
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        userRepository.save(user);
    }
}
