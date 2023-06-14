package com.security.dto;

import com.security.model.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserDTO implements Serializable {

    private String username;

    private String password;

    private Set<Role> roles;
}
