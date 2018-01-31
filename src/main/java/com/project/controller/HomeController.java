package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.Dao.UserDao;
import com.project.Model.User;



@Controller
public class HomeController {

	
	@Autowired
	UserDao userDao;
	@RequestMapping("/login")
	public ModelAndView mymethod(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("un");
		String p=req.getParameter("pwd");
		
		if(name.equalsIgnoreCase("nithya") && p.equals("123"))
			return new ModelAndView("success","message","successfully logged in!!!!");
		else
			return new ModelAndView("error","message","Username or Password Incorrect!!!!");
	}
	

	@RequestMapping("/")
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/register")
	public ModelAndView register()
	{
		return new ModelAndView("register");
	}
	
	@RequestMapping("/store")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response){  
     
		String n=request.getParameter("un");
		String p=request.getParameter("pwd");
		String addr=request.getParameter("addr");
		String mail=request.getParameter("mail");
		String phone=request.getParameter("phone");
		String country=request.getParameter("country");
		
		if(!(mail.matches("\\S+@((gmail)|(yahoo))\\.com")) || !(phone.matches("[987]\\d{9}")))
		{
			return new ModelAndView("register");
		}
		else
		{
		User u=new User();
		u.setName(n);
		u.setPwd(p);
		u.setAddress(addr);
		u.setEmail(mail);
		u.setPhone(phone);
		u.setCountry(country);
		userDao.addUser(u);
	//	request.getSession().setAttribute("obj", u);
        return new ModelAndView("suc");
		}
       // return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping  
    }  
	@RequestMapping("/index")
	public ModelAndView index1()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping("/getAllUser")
	public ModelAndView InvokeAll(HttpServletRequest request)
	{
		List<User> ll=userDao.getAllUser();
		request.getSession().setAttribute("obj", ll);
		return new ModelAndView("reteriveAll");
		
	}
	
	@RequestMapping("/reteriveAll")
	public ModelAndView reterive()
	{
		return new ModelAndView("reteriveAll");
	}
	@RequestMapping("/success")
	public ModelAndView success()
	{
		return new ModelAndView("success");
	}
	@RequestMapping("/error")
	public ModelAndView error()
	{
		return new ModelAndView("error");
	}
	@RequestMapping("/signin")
	public ModelAndView signin()
	{
		return new ModelAndView("login");
	}
	@RequestMapping("/suc")
	public ModelAndView sucRegister()
	{
		return new ModelAndView("suc");
	}

}

