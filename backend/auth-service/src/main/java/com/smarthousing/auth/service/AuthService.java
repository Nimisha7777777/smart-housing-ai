package com.smarthousing.auth.service;

import com.smarthousing.auth.dto.request.RegisterSocietyRequest;
import com.smarthousing.auth.dto.response.RegisterSocietyResponse;

public interface AuthService {

    RegisterSocietyResponse registerSociety(RegisterSocietyRequest request);

}
