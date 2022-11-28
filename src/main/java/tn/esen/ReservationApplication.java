package tn.esen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import tn.esen.control.ClientController;
import tn.esen.model.Categorie;
import tn.esen.model.Endroit;
import tn.esen.model.Proprietaire;
import tn.esen.repository.CategorieRepository;
import tn.esen.repository.EndroitRepository;
import tn.esen.repository.PersonneRepository;

@SpringBootApplication
public class ReservationApplication {
	
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ReservationApplication.class, args);
		
		
		/*catrep = context.getBean(CategorieRepository.class);
		
		 Categorie catg = new Categorie();
		    catg.setType("Salle de cinéma");
		    catrep.save(catg);*/
		    

	}

}
