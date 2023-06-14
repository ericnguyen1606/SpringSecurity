package com.security.utils;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResponseAPI implements Serializable {
    private int code;

    private String message;

    private Object metadata;
}
