package br.com.vinicius.crud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class HomeController {

	@GetMapping(path = "/")
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("boasVindas", "Bem vindo ao curso de Spring com Thymeleaf");

		List<String> lessons = new ArrayList<>();

		lessons.add("Aula 01 - Introdução");
		lessons.add("Aula 02 - Template engines");
		lessons.add("Aula 03 - Arquivos estáticos");

		modelMap.addAttribute("lessons", lessons);

		return "home";
	}

	@GetMapping("/message")
	public ModelAndView message() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("message");
		modelAndView.addObject("message", "Menssagem vinda do servidor");
		return modelAndView;
	}

	@GetMapping(path = "/greetings")
	public ModelAndView greetings(
			@RequestParam(required = false, defaultValue = "Spring", value = "name") String name) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("greetings");
		modelAndView.addObject("message", name);
		return modelAndView;
	}
}
