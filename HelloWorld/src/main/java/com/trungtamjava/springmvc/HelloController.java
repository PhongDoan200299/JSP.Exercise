package com.trungtamjava.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHello(Model map) {
		map.addAttribute("msg","Trung Tam Java");
		return "hello";
	}
}
