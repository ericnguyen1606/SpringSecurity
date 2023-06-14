package com.security.service;

import com.security.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO add(UserDTO userDTO);

    List<UserDTO> findAll();

    UserDTO findById(Long id);
}
