package com.fms.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.services.UserService;
import com.fms.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userservice;

	public UserRegistrationController(UserService userservice) {
		super();
		this.userservice = userservice;
	}
	
	
	@ModelAttribute("user")
	public UserRegistrationDto userregisterdto()
	{
		return new UserRegistrationDto();
	}
	@GetMapping
	public String showRegisterform(Model model)
	
	{
		model.addAttribute("user", new UserRegistrationDto());  
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationdao)
	{
		userservice.save(registrationdao);
		return "redirect:/registration?success";
	}
	

}
