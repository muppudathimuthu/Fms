package com.fms.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fms.web.dto.UserRegistrationDto;
import com.login.model.User;

public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationdao);

}
