package by.dach.app.controller;

import by.dach.app.model.BodyType;
import by.dach.app.model.Transmission;
import by.dach.app.model.User;
import by.dach.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return "user/update-form";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.saveUser(user); //save сам определяет сох или обн
        return "redirect:/";
    }

    @GetMapping("info/{id}")
    public String showUserInfo(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user/info";
    }


    @GetMapping("find-all-by-car-transmission-type")
    public String findAllUserByCarTransmissionType(Model model, @RequestParam("transmissionType") Transmission trType) {
        model.addAttribute("user", userService.findAllUserByCarTransmissionType(trType));
        return "user/show-list";
    }

    @GetMapping("find-all-by-car-body-type")
    public String findAllUserByCarBodyType(Model model, @RequestParam("bodyType") BodyType bodyType) {
        model.addAttribute("user", userService.findAllUserByCarBodyType(bodyType));
        return "user/show-list";
    }

    @GetMapping("show-all-with-pagination")
    public String findAll(Model model, Pageable pageable,
                          @RequestParam("sort") String sort) {
        Page<User> pageUsers = userService.findAll(pageable);
        model.addAttribute("userPage", pageUsers);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, pageUsers.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("sort", sort);
        return "user/show-all-with-pagination-and-sorted";
    }

    @GetMapping("find-all-where-car-volume-bigger")
    public String findAllUserWhereCarVolumeBigger(Model model, Pageable pageable,
                                                  @RequestParam("volume") int volume,
                                                  @RequestParam("sort") String sort) {
        //все равно нужно получать в параметрах критерий по которому делаем сортировку (sort),
        // что бы сформировать таймлифом ссылку на след страницы
        //из самого объекта pageable вытянуть можно, но только с вознёй со строками
        Page<User> pageUser = userService.findAllUserWhereCarVolumeBigger(pageable, volume);
        model.addAttribute("userPage", pageUser);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, pageUser.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("sort", sort);
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
