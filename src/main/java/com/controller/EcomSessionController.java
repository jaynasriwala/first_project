package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bean.EUserBean;
import com.dao.EuserDao;


@Controller
public class EcomSessionController 
{
	@Autowired
	EuserDao userDao;

	@GetMapping("/esignup")
	public String signup()
	{
		return "EcomSignup";
	}
	
	
	@PostMapping("/esignup")
	public String signupPost(EUserBean userBean) 
	{
		
	
		userDao.insertUser(userBean);
		return "EcomLogin";
	}
	
}
