package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.bean.StudentBoxRegBean;


@Controller
public class StudentBoxCricate 
{

	@GetMapping("/studentreg")
	public String studentreg() {
		
		return "BoxCricateReg";
	}
	

	@PostMapping("/savestudent")
	public String savestudent(StudentBoxRegBean student,Model model ) {
		
		System.out.println(student.getStudentName());
		System.out.println(student.getPlayerType());
		System.out.println(student.getFoodPreference());
		System.out.println(student.getDrink());
		
		String alphaRegEx = "[A-Za-z]+";// a-z/A-Z ? min 1 or max n
		
		boolean flag=false;
		if (student.getStudentName() == null || student.getStudentName().trim().length() == 0)
		{
			flag = true;
			model.addAttribute("nameError","*Enter student name");
		}
		else if (student.getStudentName().matches(alphaRegEx) == false)
		{
			flag = true;
			model.addAttribute("nameError","*Enter velid student name");

		}
		else 
		{
			model.addAttribute("StudentName",student.getStudentName());

		}
		
		
		
		if (student.getPlayerType() == null )
		{
			flag = true;
			model.addAttribute("playertype","*Enter Player type");
		}
		else
		{
			model.addAttribute("playertypevalue",student.getPlayerType());
		}
		
		
		
		
		if (student.getFoodPreference().equals("-1") )
		{
			flag = true;
			model.addAttribute("food","*Enter Food Preference");
		}
		else
		{
			model.addAttribute("foodvalue",student.getFoodPreference());
		}
		
		
		
		
		if (student.getDrink() == null )
		{
			flag = true;
			model.addAttribute("drink","*Enter drink");
		}
		else
		{
			model.addAttribute("drinkvalue",student.getDrink());
		}
		
		
		if (flag)
		{
			return "BoxCricateReg";
		}
		else 
		{
			model.addAttribute("s",student);
			
			model.addAttribute("mess","Register Sussessfully !..");
			return "yourdata";
		}
		
	}
	
}
