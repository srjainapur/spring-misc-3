package com.java.spring.mvc.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring.mvc.bean.Customer;

@Controller
public class CustomerController {
	private Map<String, Customer> customers = null;

	public CustomerController() {
		customers = new HashMap<String, Customer>();
	}

	@RequestMapping(value = "/cust/save", method = RequestMethod.GET)
	public String saveCustomerPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "custSave";
	}

	@RequestMapping(value = "/cust/save.do", method = RequestMethod.POST)
	public String saveCustomerAction(@Valid Customer customer, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Returning custSave.jsp page");
			return "custSave";
		}
		System.out.println("Returning custSaveSuccess.jsp page");
		model.addAttribute("customer", customer);
		customers.put(customer.getEmail(), customer);
		return "custSaveSuccess";
	}
}
