package com.cruds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cruds.entity.Department;
import com.cruds.service.DepartmentService;

@Controller
public class DeptController {
	
	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping(value="home.html")
	public String showHomePage()
	{
		return "home";
	}

	
	@RequestMapping(value="department.html" ,method=RequestMethod.GET)
	public String showForm(Model model)
	{
		model.addAttribute("command", new Department());
		model.addAttribute("DEPTLIST", deptService.getAll());
		return "dept";
	}
	
	@RequestMapping(value="department.html" ,method=RequestMethod.POST)
	public String doDepartment(@ModelAttribute("department") Department d)
	{
		deptService.create(d);
		System.out.println(d);
		return "redirect:department.html";
	}
	
	@RequestMapping(value="/dept-del-{deptId}",method=RequestMethod.GET)
	public String deleteDeptId(@PathVariable("deptId") int deptId)
	{
		deptService.delete(deptId);
		System.out.println("Deleting deptId " + deptId);
		return "redirect:department.html";
	}
	
	@RequestMapping(value="/dept-edit-{deptId}",method=RequestMethod.GET)
	public String editDept(@PathVariable("deptId") int deptId , Model model)
	{
		model.addAttribute("command",deptService.edit(deptId));
		return "editdept";
	}

	@RequestMapping(value="editDept.html",method=RequestMethod.POST)
	public String updateDept(@ModelAttribute("department") Department d)
	{
		deptService.update(d);
		return "redirect:department.html";
	}

	


}
