package com.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EProductBean;
import com.dao.EProductDao;

public class UserProductController 
{
	@Autowired
	EProductDao productDao;

	@GetMapping("/userproducts")
	public String listProducts(Model model) {
		List<EProductBean> products = productDao.getAllProduct();// return type

		model.addAttribute("products", products);

		return "EcomUserProducts";
	}

}
