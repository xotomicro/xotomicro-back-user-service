package com.boilerplate.xotomicro_back_user_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.boilerplate.xotomicro_back_user_service.dto.UserDto;
import com.boilerplate.xotomicro_back_user_service.model.User;
import com.boilerplate.xotomicro_back_user_service.repository.UserRepository;

@Component
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(User::toUserDto).collect(Collectors.toList());
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
