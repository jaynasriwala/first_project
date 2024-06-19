package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EProductBean;
import com.dao.EProductDao;





@Controller
public class EcomProductController 
{

	@Autowired
	EProductDao productDao; 
	
	@GetMapping("/newproduct")
	public String newProduct() {
		return "NewProduct";
	}
	
	@PostMapping("/newproduct")
	public String postMethodName(EProductBean productbean , Model model) {
	
		
		
		boolean flag = false;
		if(productbean.getProductName() == null || productbean.getProductName().trim().length() == 0)
		{
			flag = true;
			model.addAttribute("nameError","* Enter product name");
		}
		else
		{
			model.addAttribute("productname",productbean.getProductName());
		}
		
		
		
		
		if (flag)
		{
			
			return "NewProduct";
		}
		else 
		{	
			productDao.addProduct(productbean);
			return "welcome";
			
		}
	}
	
	
}
