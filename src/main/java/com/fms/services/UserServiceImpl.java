package com.fms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fms.repositories.UserRepository;
import com.fms.web.dto.UserRegistrationDto;
import com.login.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userrepo )
	{
		super();
		this.userrepo=userrepo;
	}
	
	
	@Override
	public User save(UserRegistrationDto registrationdao)
	{
		User user=new User(registrationdao.getUsername(),passwordEncoder.encode(registrationdao.getPassword()),registrationdao.getPhoneno(),registrationdao.getEmail());
		return userrepo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException
	{
		User user=userrepo.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("invalid username and password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getemail(),user.getPassword(),null);
		
		
	}
	
	
	

}
