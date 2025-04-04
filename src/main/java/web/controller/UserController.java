package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")   // Добавлено
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index"; // шаблон index.html
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "user-list";
    }

    @GetMapping("/add")
    public String showAddUserForm() {
        return "user-add";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("age") byte age) {
        userService.createUser(name, age);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("age") byte age) {
        userService.updateUser(id, name, age);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
