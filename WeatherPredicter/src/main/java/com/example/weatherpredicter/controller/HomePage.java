/*
 * Renders homepage
 */
package com.example.weatherpredicter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomePage {

	/*
	 * Returns Homepage of the WebPredicter Application
	 */
	@RequestMapping(method = GET)
	public String homepage() {
		return "index.html";
	}
	
}
