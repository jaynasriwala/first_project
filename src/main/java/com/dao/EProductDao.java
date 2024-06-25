package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	
	public List <EProductBean> getAllProduct()
	{		
		List <EProductBean> list= stmt.query("select * from products", new BeanPropertyRowMapper<EProductBean>(EProductBean.class));
		
		return list;
	}
	
	public void deleteProduct(Integer id)
	{
		stmt.update("delete from products where productId = ? ",id);
	}
}
