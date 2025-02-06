package com.michelle.project.service;


import com.michelle.project.dtos.UserRequest;
import com.michelle.project.dtos.UserResponse;
import com.michelle.project.entity.UserEntity;
import com.michelle.project.enums.Role;
import com.michelle.project.exception.UserNotFoundException;
import com.michelle.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity findByUsername(String username) throws UserNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username : " + username));
    }

    @Override
    public UserResponse findByEmail(String email) throws UserNotFoundException {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found with email : " + email));
        return UserResponse.builder().email(user.getEmail()).phone(user.getPhone()).username(user.getUsername()).build();
    }

    @Override
    public void save(UserRequest user) {
        userRepository.save(UserEntity.builder().role(Role.ROLE_USER).phone(user.phoneNumber()).email(user.email())
                .password(user.password()).username(user.username()).build());
    }
}
