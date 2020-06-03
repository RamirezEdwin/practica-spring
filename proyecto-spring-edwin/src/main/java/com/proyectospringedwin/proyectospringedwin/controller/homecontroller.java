package com.proyectospringedwin.proyectospringedwin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homecontroller {

	@GetMapping({"/index","/home","/"})
	public String index() {
		
		return "home";
		
		
	}
}
 