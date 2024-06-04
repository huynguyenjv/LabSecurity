package fit.hutech.labsecurity.controllers;

import fit.hutech.labsecurity.RequestEntities.UserCreate;
import fit.hutech.labsecurity.entites.User;
import fit.hutech.labsecurity.services.RoleService;
import fit.hutech.labsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("")
    private String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "User/getAll";
    }

    @GetMapping("/new")
    private String addUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles",roleService.getAllRole());
        return "User/add";
    }

    @PostMapping("/save")
    private String saveUser(UserCreate userCreate, Model model, BindingResult result){
        if (result.hasErrors()) {
            model.addAttribute("roles", roleService.getAllRole());
            return "/User/add";
        }
        userService.createUser(userCreate);
        return "redirect:/user";
    }


    @GetMapping("/edit/{id}")
    private String editUser(@PathVariable String id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRole());
        return "User/edit";
    }

    @PostMapping("/save-update/{id}")
    private String saveUserEdit(@PathVariable String id, UserCreate userCreate,Model model, BindingResult result){
        if (result.hasErrors()) {
            userCreate.setId(id);
            model.addAttribute("roles", roleService.getAllRole());// set id to keep it in the form in case of errors
            return "/User/edit";
        }
        userService.updateUser(userCreate);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    private String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
