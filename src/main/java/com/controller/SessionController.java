package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.Addition;
import com.bean.UserBean;

@Controller
public class SessionController 
{
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	
	@GetMapping("/singup")
	public String singup()
	{
		return "singup";
	}
	
	@GetMapping("/fp")
	public String fp()
	{
		return "forgotpassword";
	}
	@GetMapping("/cal")
	public String cal()
	{
		return "caladd";
	}
	
	@PostMapping("/add")
	public String add(Addition add, Model model  )
	{
		model.addAttribute("add",add);
		return "add";
	}
	
	@PostMapping("/usersave")
	public String usersave(UserBean userbean ,Model model)
	{
		System.out.println("First name=> "+userbean.getFirstname());
		System.out.println("email=> "+userbean.getEmail());
		System.out.println("password=> "+userbean.getPassword());
		
		model.addAttribute("user",userbean);
		
		return "login";
	}
}
