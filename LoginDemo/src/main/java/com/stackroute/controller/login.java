package com.stackroute.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.model.UserDetails;
import com.stackroute.repository.UserRepo;

@Controller
public class login {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String display() {
		return "index";
	}

	@RequestMapping(value = "/lDetails", method = RequestMethod.POST)
	public String loginDetails(Model m, @ModelAttribute("userDetails") UserDetails userDetails) {

		List<UserDetails> list = new ArrayList<UserDetails>();
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepo ur = (UserRepo) context.getBean("user");

		list.add(userDetails);
		ur.setUser(list);

		for (UserDetails s : ur.getUser()) {
			m.addAttribute("name", s.getName());
			m.addAttribute("phoneNumber", s.getPhoneNumber());
			// System.out.println(s.getName());
			// System.out.println(s.getPhoneNumber());
		}
		return "homePage";
	}
}
