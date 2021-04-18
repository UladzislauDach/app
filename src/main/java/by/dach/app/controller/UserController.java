package by.dach.app.controller;

import by.dach.app.model.Transmission;
import by.dach.app.model.User;
import by.dach.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return "user-main";
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
        return "redirect:http://localhost:8080/";
    }

    @GetMapping("user-info/{id}")
    public String showUserInfo(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user-info";
    }


    @GetMapping("find-all-user-by-car-transmission-type")
    public String findAllUserByCarTransmissionType(Model model, @Param("tr_type") Transmission tr_type) {
        model.addAttribute("user", userService.findAllUserByCarTransmissionType(tr_type));
        return "show-list-users";
    }

    @GetMapping("find-all-user-by-car-body-type")
    public String findAllUserByCarBodyType(Model model, @Param("body_type") String bodyType) {
        model.addAttribute("user", userService.findAllUserByCarBodyType(bodyType));
        return "show-list-users";
    }

    @GetMapping("show-all-users-with-pagination")
    public String findAllByIdIsNot(Model model,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                   @Param("sortType") String sortType) {
        Sort sort = Sort.by(sortType);
        Page<User> pageUsers = userService.findAll(page - 1, size, sort);
        model.addAttribute("userPage", pageUsers);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, pageUsers.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("sortType", sortType);
        return "show-all-users-with-pagination-and-sorted";
    }

    @GetMapping("find-all-user-where-car-volume-biggest")
    public String findAllUserWhereCarVolumeBiggest(Model model,
                                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                   @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                                   @Param("volume") int volume) {
        Page<User> pageUser = userService.findAllUserWhereCarVolumeBiggest(page - 1, size, volume);
        model.addAttribute("userPage", pageUser);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, pageUser.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("volume", volume);
        return "show-list-users-by-car-volume-with-pagination";
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
