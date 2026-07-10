package com.smarthousing.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterSocietyResponse {

    private Long societyId;

    private Long adminId;

    private String message;

}
