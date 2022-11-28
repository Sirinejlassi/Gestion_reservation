package tn.esen.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import tn.esen.model.reservation;
import tn.esen.repository.EndroitRepository;
import tn.esen.repository.ReservationRepository;
@Controller
public class reservationControl {
	@Autowired
	ReservationRepository resRep;
	@Autowired
	EndroitRepository endRep;

	/*Get By Id*/
	@GetMapping("/getReservation/{idend}")
	public String showUpdateForm(@PathVariable("idend") Long idend, Model model) {
		List<reservation> res = resRep.findByEndroit(endRep.findById(idend));
		model.addAttribute("reservation",res);
		return "listReser";
	
	}

}
