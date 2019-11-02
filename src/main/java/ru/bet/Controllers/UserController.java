package ru.bet.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bet.Repo.UserRepo;
import ru.bet.Role;
import ru.bet.User;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user,
                               Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam String username,
                           @RequestParam Map<String,String> form,
                           @RequestParam("userId") User user){
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);

        return "redirect:/user";
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
