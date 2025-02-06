package com.michelle.project.controller;


import com.michelle.project.dtos.UserRequest;
import com.michelle.project.dtos.UserResponse;
import com.michelle.project.exception.UserNotFoundException;
import com.michelle.project.service.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/add_user")
    public String addUser(@RequestBody @Valid UserRequest userRequest) {
        userService.save(userRequest);
        return "User save successfully..";
    }

    @GetMapping("/get_by_email/{email}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserResponse getByEmail(@PathVariable("email") @Email  String email) throws UserNotFoundException {
        return userService.findByEmail(email);
    }


    @GetMapping("/passCommand")
    @PreAuthorize("isFullyAuthenticated()")
    public String passCommand(@Valid UserRequest userRequest) throws UserNotFoundException {
        return "Commande passé avec succès..";
    }
}
