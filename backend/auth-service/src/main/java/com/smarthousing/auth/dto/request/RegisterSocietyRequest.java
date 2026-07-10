package com.smarthousing.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterSocietyRequest {

    @NotBlank
    private String societyName;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String pincode;

    @Email
    private String societyEmail;

    @NotBlank
    private String societyPhone;

    @NotBlank
    private String adminFirstName;

    @NotBlank
    private String adminLastName;

    @Email
    private String adminEmail;

    @NotBlank
    private String adminPhone;

    @NotBlank
    private String password;
}
