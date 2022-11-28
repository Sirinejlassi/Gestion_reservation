package tn.esen.control;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esen.model.Categorie;
import tn.esen.model.Client;
import tn.esen.model.Endroit;
import tn.esen.model.Personne;
import tn.esen.model.Proprietaire;
import tn.esen.repository.ClientRepository;
import tn.esen.repository.PersonneRepository;

@Controller
public class ClientController {
	@Autowired ServletContext context;
	@Autowired
	PersonneRepository perRep;
	@Autowired
	ClientRepository clRep;
	
	@GetMapping("/Acceuil")
	public String Show() {
		
		return "Acceuil";
	}
	@GetMapping("/ajoutCl")
	public String ShowAddForm(Model model) {
		Client client = new Client();
		model.addAttribute("client",client);
		
		return "addClient";
	}
	
	/*Ajout client*/
	@PostMapping("/Addclient")
	public String createClient(@ModelAttribute("client") Client client) {
		perRep.save(client);
		return "redirect:/client";
	}
	/*Lister tout les client*/
	@GetMapping("/client")
	public String ListEndroit(Model model) {
		List<Client> client = clRep.findAll();
		model.addAttribute("clients",client);
		return "client";
	}
	/*Get By Id*/
	@GetMapping("/client/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Client client = clRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
		model.addAttribute("client",client);
		return "updateClient";
	}
	/*Modification*/
	@PostMapping("/client/{id}")
	public String updateUser(@PathVariable("id") long id, @Validated Client cl, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        cl.setId(id);
	        return "updateClient";
	    }
	        
	    perRep.save(cl);
	    return "redirect:/client";
	}
	/*suppression*/
	@GetMapping("/deleteCl/{id}")
	public String deleteProp(@PathVariable("id") long id, Model model) {
	    Client cl = clRep.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    clRep.delete(cl);
	    return "redirect:/client";
	}
	

}
