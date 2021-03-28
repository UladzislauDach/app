package by.dach.app.controller;

import by.dach.app.model.User;
import by.dach.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/users")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("users", list);
        return "show-all-users";
    }

    @GetMapping("/new-user")
    public String newUser(User user) {
// почему через модель тоже работает?
// model.addAttribute("user", new User());
        return "new-user-form";
    }

    @PostMapping("/save-user")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:http://localhost:8080/";
    }

    @GetMapping("/update-user/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute(user);
        return "update-user-form";
    }

    @PostMapping("/update-user")
    public String updateUser(User user) {
        userService.saveUser(user); //save сам определяет сох или обн
        return "redirect:";
    }

    @GetMapping("user-info/{id}")
    public String showUserInfo (@PathVariable (name = "id") int id, Model model){
        return "user-info";
    }

    @GetMapping("/test")
    @ResponseBody
    public User test() {
        User user = new User();
        user.setName("Jack");
        user.setAge(21);
        return user;
    }


}
