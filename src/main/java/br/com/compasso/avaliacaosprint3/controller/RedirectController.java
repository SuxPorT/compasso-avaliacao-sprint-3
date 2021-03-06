package br.com.compasso.avaliacaosprint3.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController implements ErrorController {

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/api/cars";
	}
	
	@RequestMapping("/api")
	public String redirectApi() {
		return "redirect:/api/cars";
	}
	
    @RequestMapping("/error")
    public String handleError() {
    	return "redirect:/api/cars";
    }
	
}
