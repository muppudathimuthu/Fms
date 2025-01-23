package com.fms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.repositories.UserRepository;
import com.fms.web.dto.UserRegistrationDto;
import com.login.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userrepo;
	
	public UserServiceImpl(UserRepository userrepo )
	{
		super();
		this.userrepo=userrepo;
	}
	
	
	@Override
	public User save(UserRegistrationDto registrationdao)
	{
		User user=new User(registrationdao.getUsername(),registrationdao.getPassword(),registrationdao.getPhoneno(),registrationdao.getEmail());
		return userrepo.save(user);
	}

}
