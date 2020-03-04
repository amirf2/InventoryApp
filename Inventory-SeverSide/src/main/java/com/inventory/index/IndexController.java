package com.inventory.index;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootIndex() {
		return "Hello, please visit localhost:8080/swagger-ui.html for the API documentation";
	}
}

