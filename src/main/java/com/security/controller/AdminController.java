package com.security.controller;

import com.security.utils.ResponseAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminController {

    public ResponseEntity<ResponseAPI> home() {
        return ResponseEntity.ok(ResponseAPI.builder()
                        .code(HttpStatus.OK.value())
                        .message("OK")
                        .metadata("Admin Controller")
                .build());
    }
}
