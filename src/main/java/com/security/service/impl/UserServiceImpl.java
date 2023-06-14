package com.security.service.impl;

import com.security.dto.UserDTO;
import com.security.model.Role;
import com.security.model.User;
import com.security.repository.RoleRepository;
import com.security.repository.UserRepository;
import com.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO add(UserDTO userDTO) {
        User user = mapToEntity(userDTO);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER").orElse(new Role("USER")));

        user.setRoles(roles);

        User save = userRepository.save(user);
        return mapToDTO(save);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no user"));
        return mapToDTO(user);
    }

    public User mapToEntity(UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        System.out.println("Password encodeer : " + passwordEncoder.encode(userDTO.getPassword()));
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(userDTO.getRoles());
        return user;
    }

    public UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
