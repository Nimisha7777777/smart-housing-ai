package com.smarthousing.auth.service.impl;

import com.smarthousing.auth.dto.request.RegisterSocietyRequest;
import com.smarthousing.auth.dto.response.RegisterSocietyResponse;
import com.smarthousing.auth.repository.SocietyRepository;
import com.smarthousing.auth.repository.UserRepository;
import com.smarthousing.auth.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final SocietyRepository societyRepository;

    public AuthServiceImpl(UserRepository userRepository,
                           SocietyRepository societyRepository) {

        this.userRepository = userRepository;
        this.societyRepository = societyRepository;
    }

    @Override
    @Transactional
    public RegisterSocietyResponse registerSociety(RegisterSocietyRequest request) {

        return null;
    }
}