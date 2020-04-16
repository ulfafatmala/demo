package com.example.demo.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public ModelMap listPenerbit() throws Exception {
		return new ModelMap("customerList", customerService.getAll());
	}

	@RequestMapping(value="/form", method = RequestMethod.GET)
	public ModelMap findById(@RequestParam(value="id", required=false) String customerId) {
		Customer customer = new Customer();
		if(customerId != null) {
			customer = customerService.getById(customerId);
			if(customer == null) {
				customer = new Customer();
			}
		}
		return new ModelMap().addAttribute("customer",customer);
	}
	
	@PostMapping("/form")
	public String prosesForm(@ModelAttribute @Valid Customer customer, BindingResult errors,
			SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			return "/customer/form";
		}
		customerService.saveCustomer(customer);
		sessionStatus.setComplete();
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String id) {
		customerService.deleteCustomer(id);
		return "redirect:list";
	}
}
