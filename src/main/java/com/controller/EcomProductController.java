package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EProductBean;
import com.dao.EProductDao;
import org.springframework.web.bind.annotation.RequestParam;






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
			return "redirect:/product";
			
		}
	}
	
	@GetMapping("/product")
	public String products(Model model) 
	{
		List<EProductBean> products = productDao.getAllProduct();
		
		model.addAttribute("products",products);
		
		
		return "EProductlist";
	
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("productId") Integer productId) {
		
		productDao.deleteProduct(productId);
		return "redirect:/product";
	}
	
	@GetMapping("/deletebyname")
	public String deleteByName()
	{
		
		return "DeleteByName";
	}
	
	@PostMapping("/deletebyname")
	public String deleteByName(EProductBean productbean)
	{
		
		productDao.deleteProduct(productbean.getProductName());
		return "redirect:/product";
		
	}
	
	@GetMapping("/viewproduct")
	public String viewProduuct(@RequestParam ("productId") Integer productId,Model model) {
		
		EProductBean bean = productDao.getProductById(productId);
		
		model.addAttribute("productbean",bean);
		
		return "ViewProduct";
	}
	
	
	
}
