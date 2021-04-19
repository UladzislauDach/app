package by.dach.app.controller;

import by.dach.app.model.Transmission;
import by.dach.app.model.User;
import by.dach.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public String mainPage(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("users", list);
        return "user/main";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/form-of-creation";
    }

    @PostMapping("/save")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute(user);
        return "update-form";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.saveUser(user); //save сам определяет сох или обн
        return "redirect:/";
    }

    @GetMapping("info/{id}")
    public String showUserInfo(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "info";
    }


    @GetMapping("find-all-by-car-transmission-type")
    public String findAllUserByCarTransmissionType(Model model, @RequestParam("tr_type") Transmission tr_type) {
        model.addAttribute("user", userService.findAllUserByCarTransmissionType(tr_type));
        return "show-list";
    }

    @GetMapping("find-all-by-car-body-type")
    public String findAllUserByCarBodyType(Model model, @RequestParam("body_type") String bodyType) {
        model.addAttribute("user", userService.findAllUserByCarBodyType(bodyType));
        return "user/show-list";
    }

    @GetMapping("show-all-with-pagination")
    public String findAllByIdIsNot(Model model,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                   @RequestParam("sortType") String sortType) {
        Sort sort = Sort.by(sortType);
        Page<User> pageUsers = userService.findAll(page - 1, size, sort);
        model.addAttribute("userPage", pageUsers);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, pageUsers.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("sortType", sortType);
        return "user/show-all-with-pagination-and-sorted";
    }

    @GetMapping("find-all-where-car-volume-bigger")
    public String findAllUserWhereCarVolumeBigger(Model model,
                                                  @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                  @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                                  @RequestParam("volume") int volume) {
        Page<User> pageUser = userService.findAllUserWhereCarVolumeBigger(page - 1, size, volume);
        model.addAttribute("userPage", pageUser);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, pageUser.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("volume", volume);
        return "user/show-list-by-car-volume-with-pagination";
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
