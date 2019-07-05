package com.haris.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.haris.demo.dao.EmpDao;
import com.haris.demo.model.Employee;

@Controller
public class EmpController {

	@Autowired
	EmpDao dao;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/AddEmployees")
	public ModelAndView AddEmployees(Employee emp) {

		ModelAndView mv = new ModelAndView("home.jsp");
		dao.save(emp);
		return mv;
	}
	
	@ResponseBody
	@PostMapping(path = "/emp")
	public Employee Add(@RequestBody Employee emp) {		
		dao.save(emp);
		return emp;
	}
	
	
	@ResponseBody
	@DeleteMapping("/emp/{id}")
	public String delete(@PathVariable int id) {		
		
		Employee e = dao.getOne(id);
		dao.delete(e);
		return "Record Deleted Sucessfully";
	}

	@ResponseBody
	@PutMapping(path = "/emp")
	public Employee Update(@RequestBody Employee emp) {		
		dao.save(emp);
		return emp;
	}
	/*
	 * @RequestMapping("/getEmployees") public ModelAndView
	 * getEmployees(@RequestParam int id) {
	 * 
	 * ModelAndView mv = new ModelAndView("showemp.jsp");
	 * 
	 * Employee employee = dao.findById(id).orElse(null);
	 * 
	 * System.out.println(dao.findByDesignation("Software"));
	 * mv.addObject(employee);
	 * 
	 * return mv; }
	 */
	// @RequestMapping(path ="/emp" , produces = {"application/xml"}) For Support Xml Only
	
	
	
	@RequestMapping("/emp")
	@ResponseBody
	public List<Employee> getEmployees() {
		
		return dao.findAll();
	}
	
	@RequestMapping("/emp/{id}")
	@ResponseBody
	public Optional<Employee> getEmployee(@PathVariable("id") int id) {
	
		return dao.findById(id);
	}

}
