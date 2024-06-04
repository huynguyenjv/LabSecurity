package fit.hutech.labsecurity.controllers;

import fit.hutech.labsecurity.RequestEntities.RoleCreate;
import fit.hutech.labsecurity.entites.Role;
import fit.hutech.labsecurity.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("")
    private String getAllRole(Model model){
        model.addAttribute("roles", roleService.getAllRole());
        return "Role/getAll";
    }

    @GetMapping("/new")
    private String addRole(Model model){
        Role role = new Role();
        model.addAttribute("role", role);
        return "Role/add";
    }

    @PostMapping("/save")
    private String saveRole(RoleCreate roleCreate){
        roleService.createRole(roleCreate);
        return "redirect:/role";
    }

    @GetMapping("/edit/{id}")
    private String editRole(@PathVariable Integer id, Model model){
        Role role = roleService.getRoleById(id);
        model.addAttribute("role",role);
        return "Role/edit";
    }

    @PostMapping("/save-update")
    private String saveUpdate(RoleCreate roleCreate){
        roleService.updateRole(roleCreate);
        return "redirect:/role";
    }

    @GetMapping("/delete")
    private String deleteRole(@PathVariable Integer id){
        roleService.deleteRole(id);
        return "redirect:/role";
    }

}
