package epi.PFA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import epi.PFA.entities.Enseignant;
import epi.PFA.entities.Etudiant;
import epi.PFA.entities.PFE;
import epi.PFA.repository.PFERepository;
import epi.PFA.sevice.EnseignantService;
import epi.PFA.sevice.EtudiantService;
import epi.PFA.sevice.PFEService;

@RestController
@RequestMapping("/api/pfe/")
public class RestPFEController {
	
	
	@Autowired
	
	PFEService pfeService;
@GetMapping()
	public List<PFE> all (){ 
		return pfeService.getAllPfes();

	}

	@GetMapping ("{id}")

	public PFE getPFE (@PathVariable Long id) {

	return pfeService.findPFEById(id);

	}

	@PostMapping("add")

	public PFE addChaine (@RequestBody PFE p) { 
		return pfeService.persistPFE(p);

	}

	@DeleteMapping("{id}")

	public String deleteChaine (@PathVariable Long id) { 
		pfeService.deletePFE(id); 
		return "Suppression réussite";

	}

	@PutMapping("update")
	public PFE updatePFE (@RequestBody PFE p) {
		return pfeService.persistPFE(p);
	}

}
