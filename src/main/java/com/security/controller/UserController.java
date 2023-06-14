package com.security.controller;

import com.security.dto.UserDTO;
import com.security.service.UserService;
import com.security.utils.ResponseAPI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("User Controller");
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<ResponseAPI> signUp(@RequestBody UserDTO userDTO) {
        ResponseAPI response = ResponseAPI.builder()
                .code(HttpStatus.CREATED.value())
                .message("CREATED")
                .metadata(userService.add(userDTO))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/find-all")
    public ResponseEntity<ResponseAPI> findAll() {
        ResponseAPI response = ResponseAPI.builder()
                .code(HttpStatus.OK.value())
                .message("CREATED")
                .metadata(userService.findAll())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/find-by-id")
    public ResponseEntity<ResponseAPI> findUserById(@PathVariable Long id) {
        ResponseAPI response = ResponseAPI.builder()
                .code(HttpStatus.OK.value())
                .message("CREATED")
                .metadata(userService.findById(id))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
