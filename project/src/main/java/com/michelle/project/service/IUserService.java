package com.michelle.project.service;

import com.michelle.project.dtos.UserRequest;
import com.michelle.project.dtos.UserResponse;
import com.michelle.project.entity.UserEntity;
import com.michelle.project.exception.UserNotFoundException;

public interface IUserService {

    UserEntity findByUsername(String username) throws UserNotFoundException;

    UserResponse findByEmail(String email) throws UserNotFoundException;

    void save(UserRequest user);

}
