package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EProductBean;

@Repository
public class EProductDao 
{

	@Autowired
	JdbcTemplate stmt;
	
	public void addProduct(EProductBean productbean)
	{
		stmt.update("insert into products(productName,price,qty,category) value(?,?,?,?)",productbean.getProductName(),productbean.getPrice(),productbean.getQty(),productbean.getCategory());
		
	}
}
