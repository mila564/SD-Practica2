package sd.urjc.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import sd.urjc.proyecto.model.Especie;
import sd.urjc.proyecto.repository.EspecieRepository;

@Controller
@RequestMapping("/especies")
public class EspecieController {
	@Autowired
	private EspecieRepository repEspecies;

	@GetMapping("")
	public ResponseEntity<List<Especie>> getEspecies() {
		return new ResponseEntity<>(repEspecies.findAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	private ResponseEntity<Especie> getEspecie(@PathVariable long id) {
		Optional<Especie> especie = repEspecies.findById(id);
		if (especie.isPresent())
			return new ResponseEntity<>(especie.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}