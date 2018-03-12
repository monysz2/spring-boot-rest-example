package pl.maslowskis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.maslowskis.entity.User;
import pl.maslowskis.entity.request.AddUserRequest;
import pl.maslowskis.repository.UserRepository;

import java.util.List;

/**
 * Created by oro-6 on 3/12/2018.
 */
@RestController

public class UserController {
    private UserRepository userRepository;


    @GetMapping("/")
    public String home(ModelMap modelMap)
    {
        modelMap.put("hello","Witaj swiecie");
        return "hello";
    }

    @RequestMapping("/users")
    public String helloMessage()
    {
        return "Hello World!";
    }

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest)
    {
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        userRepository.save(user);
    }
}
