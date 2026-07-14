package com.smarthousing.auth.service.impl;

import com.smarthousing.auth.dto.request.LoginRequest;
import com.smarthousing.auth.dto.request.RegisterSocietyRequest;
import com.smarthousing.auth.dto.response.LoginResponse;
import com.smarthousing.auth.dto.response.RegisterSocietyResponse;
import com.smarthousing.auth.entity.Society;
import com.smarthousing.auth.entity.User;
import com.smarthousing.auth.enums.AccountStatus;
import com.smarthousing.auth.enums.Role;
import com.smarthousing.auth.exception.DuplicateResourceException;
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

    private void validateRegistration(RegisterSocietyRequest request) {

        if (societyRepository.existsByEmail(request.getSocietyEmail())) {
            throw new DuplicateResourceException("Society email already exists.");
        }

        if (societyRepository.existsByPhone(request.getSocietyPhone())) {
            throw new DuplicateResourceException("Society phone already exists.");
        }

        if (userRepository.existsByEmail(request.getAdminEmail())) {
            throw new DuplicateResourceException("Admin email already exists.");
        }

        if (userRepository.existsByPhone(request.getAdminPhone())) {
            throw new DuplicateResourceException("Admin phone already exists.");
        }
    }
    @Override
    @Transactional
    public RegisterSocietyResponse registerSociety(RegisterSocietyRequest request) {

        validateRegistration(request);

        Society society = createSociety(request);

        User admin = createAdminUser(request, society);

        return new RegisterSocietyResponse(

                society.getId(),

                admin.getId(),

                "Society registered successfully."

        );
    }

    private Society createSociety(RegisterSocietyRequest request) {

        Society society = new Society();

        society.setSocietyName(request.getSocietyName());
        society.setAddress(request.getAddress());
        society.setCity(request.getCity());
        society.setState(request.getState());
        society.setPincode(request.getPincode());
        society.setEmail(request.getSocietyEmail());
        society.setPhone(request.getSocietyPhone());

        return societyRepository.save(society);
    }

    private User createAdminUser(RegisterSocietyRequest request,
                                 Society society) {

        User admin = new User();

        admin.setFirstName(request.getAdminFirstName());
        admin.setLastName(request.getAdminLastName());
        admin.setEmail(request.getAdminEmail());

        admin.setPhone(request.getAdminPhone());

        admin.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        admin.setRole(Role.ADMIN);

        admin.setAccountStatus(AccountStatus.ACTIVE);

        admin.setSociety(society);

        return userRepository.save(admin);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        return null;

    }

}