package ru.bet.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bet.domen.Role;
import ru.bet.domen.User;
import ru.bet.services.UserService;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user,
                               Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(@RequestParam String username,
                           @RequestParam Map<String,String> form,
                           @RequestParam("userId") User user){
        userService.saveUser(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        return "/profile";
    }

    @PostMapping("/profile")
    public String updatePrifile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email
    ){
        userService.updateProfile(user, password, email);

        return "redirect:/user/profile";
    }

    //20191102 Пытался настроить удаление пользователей из db usr.
    // Почему то удаляются роли из db user_role. ХЗ так и не разобрался
    // Вначале удалял по id. Потом решил по username. Не помогло.
    /*@GetMapping("delete/{id}")
    public String deleteUser(@PathVariable User user,Model model) {

        User user2= userRepo.findByUsername(user.getUsername());
                *//*.orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + user.getId()));*//*
        userRepo.delete(user);
        //model.addAttribute()
        model.addAttribute("students", userRepo.findAll());

        return "/user";
    }*/
}
