package br.com.vinicius.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.vinicius.crud.models.Client;
import br.com.vinicius.crud.repositories.ClientRepository;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public ModelAndView findAllClients() {
		ModelAndView modelAndView = new ModelAndView("clients/clients.html");
		List<Client> clients = clientRepository.findAll();
		modelAndView.addObject("clients", clients);
		return modelAndView;
	}

	@GetMapping(path = "/{id}")
	public ModelAndView clientDetails(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("clients/clientById.html");
		Client client = clientRepository.findById(id).get();
		modelAndView.addObject("client", client);
		return modelAndView;
	}

	@GetMapping(path = "/{id}/delete")
	public ModelAndView deleteClient(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/clients");
		clientRepository.deleteById(id);
		return modelAndView;
	}

	@GetMapping(path = "/create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("clients/clientForm.html");
		modelAndView.addObject("client", new Client());
		return modelAndView;
	}

	@PostMapping(path = "/create")
	public ModelAndView create(Client client) {
		ModelAndView modelAndView = new ModelAndView("redirect:/clients");
		clientRepository.save(client);
		return modelAndView;
	}

	@GetMapping(path = "/{id}/edit")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("clients/clientForm.html");
		Client client = clientRepository.findById(id).get();
		modelAndView.addObject("client", client);
		return modelAndView;
	}

	@PostMapping(path = "/{id}/edit")
	public ModelAndView edit(Client client) {
		ModelAndView modelAndView = new ModelAndView("redirect:/clients");
		clientRepository.save(client);
		return modelAndView;
	}

}
