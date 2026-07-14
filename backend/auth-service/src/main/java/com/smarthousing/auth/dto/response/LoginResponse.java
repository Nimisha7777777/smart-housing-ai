package com.smarthousing.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoginResponse {

    private String token;

    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private Long societyId;

}
