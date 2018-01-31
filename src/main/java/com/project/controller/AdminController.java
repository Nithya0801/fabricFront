package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.Dao.SupplierDao;
import com.project.Model.Supplier;

@Controller
public class AdminController {

	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/insertData")
	ModelAndView insert(HttpServletRequest request)
	{
		
		String option=request.getParameter("option");
		if(option.equalsIgnoreCase("insert"))
		{
			Supplier supplier=new Supplier();
			int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		supplier.setSid(sid);
		supplier.setSname(sname);
		System.out.println(supplier.getSid());
		System.out.println(supplier.getSname());
		boolean b=supplierDao.insertSupplier(supplier);
		System.out.println(b);
		if(b)
			return new ModelAndView("suc");
		else
			return new ModelAndView("error");
		}
		else
		{
			return new ModelAndView("success");
		}
	}
	
	@RequestMapping("/insertSupp")
	public void insertSupp(HttpServletRequest request)
	{
		
	}
}
