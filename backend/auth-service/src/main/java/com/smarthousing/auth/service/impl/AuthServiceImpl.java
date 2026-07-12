package com.smarthousing.auth.service.impl;

import com.smarthousing.auth.dto.request.RegisterSocietyRequest;
import com.smarthousing.auth.dto.response.RegisterSocietyResponse;
import com.smarthousing.auth.repository.SocietyRepository;
import com.smarthousing.auth.repository.UserRepository;
import com.smarthousing.auth.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final SocietyRepository societyRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthServiceImpl(
            UserRepository userRepository,
            SocietyRepository societyRepository,
            BCryptPasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.societyRepository = societyRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    @Transactional
    public RegisterSocietyResponse registerSociety(RegisterSocietyRequest request) {
        return null;
    }
}