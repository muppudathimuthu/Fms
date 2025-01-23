package com.fms.services;

import com.fms.web.dto.UserRegistrationDto;
import com.login.model.User;

public interface UserService {

	User save(UserRegistrationDto registrationdao);

}
