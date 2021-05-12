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
		repEspecies.save(new Especie("Manzano", "Malus domestica", Arrays.asList(repPlagas.findByNombreVulgar("Polilla del aliso").get(), repPlagas.findByNombreVulgar("Oruga de zurrón").get(), repPlagas.findByNombreVulgar("Cigarrita de espuma").get())));
		repEspecies.save(new Especie("Peral", "Pyrus communis", Arrays.asList(repPlagas.findByNombreVulgar("Polilla del aliso").get(), repPlagas.findByNombreVulgar("Oruga de zurrón").get(), repPlagas.findByNombreVulgar("Mosquito de las agallas").get())));
		repEspecies.save(new Especie("Naranjo", "Citrus sinensis", Arrays.asList(repPlagas.findByNombreVulgar("Polilla del aliso").get(), repPlagas.findByNombreVulgar("Pájaro luna").get(), repPlagas.findByNombreVulgar("Polilla leopardo").get())));
		repEspecies.save(new Especie("Fresa", "Fragaria Ananassa", Arrays.asList(repPlagas.findByNombreVulgar("Piojo Rojo de California").get(), repPlagas.findByNombreVulgar("Pájaro luna").get(), repPlagas.findByNombreVulgar("Gorgojo perforador de los chopos").get())));
		repEspecies.save(new Especie("Vid", "Vitis vinifera", Arrays.asList(repPlagas.findByNombreVulgar("Mosca blanca").get(), repPlagas.findByNombreVulgar("Escarabajo Khapra").get())));
		repEspecies.save(new Especie("Alcachofa", "Cynara scolymus", Arrays.asList(repPlagas.findByNombreVulgar("Trips").get(), repPlagas.findByNombreVulgar("Ácaro púrpura").get())));
		repEspecies.save(new Especie("Lechuga", "Lactuca sativa", Arrays.asList(repPlagas.findByNombreVulgar("Minador sudamericano").get(), repPlagas.findByNombreVulgar("Cotonet de les Valls").get())));
		repEspecies.save(new Especie("Cacahuete", "Arachis hypogaea", Arrays.asList(repPlagas.findByNombreVulgar("Drosófila de alas manchadas").get(), repPlagas.findByNombreVulgar("Pulgón").get())));
																														//repPlagas.findByNombreVulgar("").get(), repPlagas.findByNombreVulgar("").get()
	}
	@GetMapping("")
	public ResponseEntity<List<Especie>> getEspecies() {
		return new ResponseEntity<>(repEspecies.findAll(), HttpStatus.OK);
	}
	@GetMapping("/{nombreVulgar}")
	private ResponseEntity<Especie> getEspecie(@PathVariable String nombreVulgar) {
		Optional<Especie> especie = repEspecies.findByNombreVulgar(nombreVulgar);
		if (especie.isPresent())
			return new ResponseEntity<>(especie.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}