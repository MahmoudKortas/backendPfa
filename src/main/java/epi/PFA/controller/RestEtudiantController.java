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

import epi.PFA.entities.Etudiant;
import epi.PFA.sevice.EtudiantService;




@RestController
@RequestMapping("/api/etudiants/")
public class RestEtudiantController {
	
	
	@Autowired
	EtudiantService etudiantService;
@GetMapping()
	public List<Etudiant> all (){ 
		return etudiantService.getAllEtudiants();

	}

	@GetMapping ("{id}")

	public Etudiant getEtudiant (@PathVariable Long id) {

	return etudiantService.findEtudiantById(id);

	}

	@PostMapping("add")

	public Etudiant addChaine (@RequestBody Etudiant e) { 
		return etudiantService.persistEtudiant(e);

	}

	@DeleteMapping("{id}")

	public String deleteChaine (@PathVariable Long id) { 
		etudiantService.deleteEtudiant(id); 
		return "Suppression réussite";

	}

	@PutMapping("update")
	public Etudiant updateEtudiant (@RequestBody Etudiant e) {
		return etudiantService.persistEtudiant(e);
	}

}
