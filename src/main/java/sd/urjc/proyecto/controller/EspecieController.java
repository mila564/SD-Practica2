package sd.urjc.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import sd.urjc.proyecto.model.Especie;
import sd.urjc.proyecto.repository.EspecieRepository;
import sd.urjc.proyecto.repository.PlagaRepository;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/especies")
public class EspecieController {
	@Autowired
	private EspecieRepository repEspecies;
	@Autowired
	private PlagaRepository repPlagas;

	@PostConstruct
	public void init() {
		repEspecies.save(new Especie("Manzano", "Malus domestica", Arrays.asList(repPlagas.getOne((long)1), repPlagas.getOne((long)2))));
		repEspecies.save(new Especie("Peral", "Pyrus communis", Arrays.asList(repPlagas.getOne((long)3), repPlagas.getOne((long)4))));
		repEspecies.save(new Especie("Naranjo", "Citrus sinensis", Arrays.asList(repPlagas.getOne((long)5), repPlagas.getOne((long)6))));
		repEspecies.save(new Especie("Fresa", "Fragaria Ananassa", Arrays.asList(repPlagas.getOne((long)7), repPlagas.getOne((long)8))));
		repEspecies.save(new Especie("Vid", "Vitis vinifera", Arrays.asList(repPlagas.getOne((long)9), repPlagas.getOne((long)10))));
		repEspecies.save(new Especie("Alcachofa", "Cynara scolymus", Arrays.asList(repPlagas.getOne((long)11), repPlagas.getOne((long)12))));
		repEspecies.save(new Especie("Lechuga", "Lactuca sativa", Arrays.asList(repPlagas.getOne((long)13), repPlagas.getOne((long)14))));
		repEspecies.save(new Especie("Cacahuete", "Arachis hypogaea", Arrays.asList(repPlagas.getOne((long)15), repPlagas.getOne((long)16))));
	}
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