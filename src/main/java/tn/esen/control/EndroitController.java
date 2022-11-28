package tn.esen.control;

import java.util.List;

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

import tn.esen.model.Categorie;
import tn.esen.model.Client;
import tn.esen.model.Endroit;
import tn.esen.model.Proprietaire;
import tn.esen.model.reservation;
import tn.esen.repository.CategorieRepository;
import tn.esen.repository.ClientRepository;
import tn.esen.repository.EndroitRepository;
import tn.esen.repository.PropRepository;
import tn.esen.repository.ReservationRepository;

@Controller
public class EndroitController {
	@Autowired
	EndroitRepository endRep;
	@Autowired
	CategorieRepository catRep;
	@Autowired
	PropRepository  proRep;
	@Autowired
	ClientRepository clRe;
	@Autowired
	ReservationRepository resRep;
	
	@GetMapping("/ajout/{id}")
	public String ShowAddForm(@PathVariable("id") long id,Model model) {
		Proprietaire prop = proRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
		model.addAttribute("proprietaire",prop);
		Endroit endroit = new Endroit();
		List<Categorie> cat = catRep.findAll();
		model.addAttribute("endroit",endroit);
		model.addAttribute("categorie", cat);
		
		return "addEndroit";
	}
	/*liste des endroits*/
	@GetMapping("/endroit")
	public String ListEndroit(Model model) {
		List<Endroit> endroit = endRep.findAll();
		model.addAttribute("endroits",endroit);
		return "listeEndroit";
	}
	/*ajouter endroit*/
	@PostMapping("/addEndroit/{id}")
	public String AjoutEndroit(@PathVariable("id") long id,@Validated Proprietaire prop,@ModelAttribute("endroit") Endroit endroit,BindingResult resultat, Model model) {
		if(resultat.hasErrors()) {
			return "addEndroit";
		}
		endRep.save(endroit);
        prop = proRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
		prop.setEndroit(endroit);
		proRep.save(prop);
		return "redirect:/endroit";
	}
	@GetMapping("/endroit/{id}")
	public String ListEndroitRe(@PathVariable("id") long id,Model model) {
		List<Endroit> endroit = endRep.findAll();
		 Client cl= clRe.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
		model.addAttribute("endroits",endroit);
		model.addAttribute("client",cl);
		return "endroit";
	}
	@GetMapping("/reservation/{iden}/{idcl}")
	public String Reservation(@PathVariable(value = "iden") Long idend,@PathVariable(value = "idcl") Long idc,Model model) {
		Endroit end = endRep.findById(idend).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + idend));
		Client cl = clRe.findById(idc).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + idend));
		model.addAttribute("endroit",end);
		model.addAttribute("client",cl);
		reservation reser = new reservation();
		model.addAttribute("reservation",reser);
		return "reservation";
	}
	/*ajouter reservation*/
	@PostMapping("/reservation/{iden}/{idcl}")
	public String AjoutReservation(@PathVariable(value = "iden") Long idend,@PathVariable(value = "idcl") Long idc,@ModelAttribute("reservation") reservation res) {
		Endroit end = endRep.findById(idend).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + idend));
		Client cl = clRe.findById(idc).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + idc));
		res.setEndroit(end);
		res.setClient(cl);
		resRep.save(res);
		return "redirect:/endroit";
	}
	/*Get By Id endroit*/
	@GetMapping("/Modification/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Endroit end = endRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
		model.addAttribute("endroit",end);
		return "updateEndroit";
	}
	/*Modification endroit*/
	@PostMapping("/ModicationEndroit/{id}")
	public String updateEndroit(@PathVariable("id") Long id, @Validated Endroit endroit, BindingResult result, Model model) {
		Endroit end = endRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
		endroit.setCat(end.getCat());
	    endRep.save(endroit);
	    
	    return "redirect:/proprietaire";
	}

}
