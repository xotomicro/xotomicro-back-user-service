package com.boilerplate.xotomicro_back_user_service.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boilerplate.xotomicro_back_user_service.dto.UserDto;
import com.boilerplate.xotomicro_back_user_service.model.User;
import com.boilerplate.xotomicro_back_user_service.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @ResponseBody
    @GetMapping("/search")
    public User getByUsername(@RequestParam("username") String username) {
        return userService.getByUsername(username);
    }
}
