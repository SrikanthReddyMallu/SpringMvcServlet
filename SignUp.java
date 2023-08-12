package com.controlToView;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUp
{
@ModelAttribute
public void commonHeadline(Model model)  //This is the common method to display every jsp view
{
	model.addAttribute("Heading","Welcome to spring Mvc");
}

@RequestMapping("/signup")
public String contact()
{
	return "signUp";
	
}

//Handler method which will specify the final destination jsp view
@RequestMapping(path="/process",method=RequestMethod.POST)
public String Process(
		              @RequestParam("UserName") String userName,
		              @RequestParam("UserEmail") String userEmail,
		              @RequestParam("UserPassword") String userPassword,Model model)
{
	System.out.println("User name is="+userName);
	//howing the details into view page
	model.addAttribute("un",userName);
	model.addAttribute("ue",userEmail);
	model.addAttribute("up",userPassword);
	return "success";
}
   
@RequestMapping(path="/processing" ,method=RequestMethod.POST)
public String Processing(@ModelAttribute User user,Model model)
{

	//System.out.println(user);
	model.addAttribute("uN",user.getUserName());
	model.addAttribute("uE",user.getUserEmail());
	model.addAttribute("uP",user.getUserPassword());
	return "successfully";
}
}
