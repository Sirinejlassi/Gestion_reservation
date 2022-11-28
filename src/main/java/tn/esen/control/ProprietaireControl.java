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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esen.model.Client;
import tn.esen.model.Endroit;
import tn.esen.model.Proprietaire;
import tn.esen.repository.EndroitRepository;
import tn.esen.repository.PersonneRepository;
import tn.esen.repository.PropRepository;

@Controller
public class ProprietaireControl {
	@Autowired ServletContext context;
	@Autowired
	PersonneRepository perRep;
	@Autowired
	PropRepository propRep;
	@Autowired
	EndroitRepository endRep;
	@GetMapping("/ajoutProp")
	public String ShowAddForm(Model model) {
		Proprietaire prop = new Proprietaire();
		model.addAttribute("proprietaire",prop);
		
		return "addProp";
	}
	/*Ajout prop*/
	@PostMapping("/addProp")
	public Proprietaire createProp(@ModelAttribute("proprietaire") Proprietaire prop, Model model) {
		
		perRep.save(prop);
		model.addAttribute("propr",prop);
		return prop;
		
	}
	/*Lister tout les proprietaire*/
	@GetMapping("/proprietaire")
	public String getAllProp(Model model){
		List<Proprietaire> prop = propRep.findAll();
		model.addAttribute("proprietaires",prop);
	
		return "proprietaire";
	}
	@GetMapping("/delete/{id}")
	public String deleteProp(@PathVariable("id") Long id, Model model) {
	    Proprietaire prop = propRep.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    propRep.delete(prop);
	    return "redirect:/proprietaire";
	}
	/*Get By Id*/
	@GetMapping("/proprietaire/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Proprietaire prop = propRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
		model.addAttribute("proprietaire",prop);
		
		return "updateProp";
	}
	/*Modification*/
	@PostMapping("/proprietaire/{id}")
	public String updateProp(@PathVariable("id") Long id, @Validated Proprietaire propDetail, BindingResult result, Model model) {
	   
		Proprietaire prop = propRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
		propDetail.setEndroit(prop.getEndroit());
	    perRep.save(propDetail);
	    
	   
	    return "redirect:/proprietaire";
	}
	

}
