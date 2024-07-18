package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.bean.EUserBean;
import com.dao.EuserDao;
import com.service.FileUplodeService;

import jakarta.servlet.http.HttpSession;


@Controller
public class EcomSessionController 
{
	@Autowired
	EuserDao userDao;

	
	@Autowired
	FileUplodeService fileUploadService;

	@GetMapping(value = { "/", "elogin" })
	public String welcome() {
		return "EcomLogin";
	}
	@GetMapping("/esignup")
	public String signup()
	{
		return "EcomSignup";
	}
	
	
	@PostMapping("/esignup")
	public String signupPost(EUserBean userBean) 
	{
		fileUploadService.uploadUserImage(userBean.getProfilePic(), userBean.getEmail());

		// images//profilepic//rock1@gmail.com//123.png

		userBean.setProfilePicPath(
				"images//profilepic//" + userBean.getEmail() + "//" + userBean.getProfilePic().getOriginalFilename());
	
		userDao.insertUser(userBean);
		return "EcomLogin";
	}
	
	// authentication
		@PostMapping("/elogin")
		public String eLogin(EUserBean userBean, Model model, HttpSession session) {
			System.out.println("32 => " + userBean.getEmail());
			System.out.println("33 => " + userBean.getPassword());

			// a
			// b
			// select * from users where email = ? and password = ?
			EUserBean dbUser = userDao.authenticate(userBean.getEmail(), userBean.getPassword());
			System.out.println(dbUser);
			if (dbUser == null) {
				model.addAttribute("error", "Invalid Credentials");
				return "EcomLogin";
			} else {

				session.setAttribute("user", dbUser);
				model.addAttribute("firstName", dbUser.getFirstName());
				model.addAttribute("profilePicPath", dbUser.getProfilePicPath());	
				System.out.println(dbUser.getProfilePicPath());
				return "EcomHome";
			}
		}
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			//destroy session 
			session.invalidate();
			return "redirect:/elogin";
		}
}
