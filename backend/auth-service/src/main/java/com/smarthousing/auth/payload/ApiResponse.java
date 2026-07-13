package com.smarthousing.auth.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ApiResponse<T> {

    private LocalDateTime timestamp;

    private int status;

    private String message;

    private T data;

}
