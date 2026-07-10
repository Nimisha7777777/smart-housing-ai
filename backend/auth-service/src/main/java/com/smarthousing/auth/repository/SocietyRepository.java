package com.smarthousing.auth.repository;

import com.smarthousing.auth.entity.Society;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocietyRepository extends JpaRepository<Society,Long> {

    Optional<Society> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

}
