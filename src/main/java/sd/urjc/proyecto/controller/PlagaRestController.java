package sd.urjc.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.urjc.proyecto.model.Plaga;
import sd.urjc.proyecto.repository.PlagaRepository;
import sd.urjc.proyecto.repository.SustanciaActivaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/plagas")
public class PlagaRestController {
	
	@Autowired
	private PlagaRepository repPlagas;
	
	@Autowired
	private SustanciaActivaRepository repSustanciaActiva;
	
	@PostConstruct
	public void init() {
		repPlagas.save(new Plaga("Polilla del aliso","Acronicta alni",
				"http://plagas.es/aliso", Arrays.asList(repSustanciaActiva.getOne((long) 1),
										 repSustanciaActiva.getOne((long) 2),
										 repSustanciaActiva.getOne((long) 9),
										 repSustanciaActiva.getOne((long) 17))));
		repPlagas.save(new Plaga("Oruga de zurrón","Euproctis chrysorrhoea",
				"http://plagas.es/zurron", Arrays.asList(repSustanciaActiva.getOne((long) 1),
						 				 repSustanciaActiva.getOne((long) 2),
						 				 repSustanciaActiva.getOne((long) 5),
						 				 repSustanciaActiva.getOne((long) 14),
						 				 repSustanciaActiva.getOne((long) 19))));
		repPlagas.save(new Plaga("Pájaro luna","Phalera bucephala",
				"http://plagas.es/luna", Arrays.asList(repSustanciaActiva.getOne((long) 1),
										 repSustanciaActiva.getOne((long) 2),
										 repSustanciaActiva.getOne((long) 7))));
		repPlagas.save(new Plaga("Piojo Rojo de California","Aonidiella auranti",
				"http://plagas.es/piojoRojo", Arrays.asList(repSustanciaActiva.getOne((long) 3),
										 repSustanciaActiva.getOne((long) 4),
										 repSustanciaActiva.getOne((long) 5),
										 repSustanciaActiva.getOne((long) 6))));
		repPlagas.save(new Plaga("Mosca blanca","Bemisia tabaci",
				"http://plagas.es/moscaBlanca", Arrays.asList()));
		repPlagas.save(new Plaga("Escarabajo Khapra","Trogoderma granarium",
				"http://plagas.es/khapra", Arrays.asList(repSustanciaActiva.getOne((long) 3),
										 repSustanciaActiva.getOne((long) 4),
										 repSustanciaActiva.getOne((long) 5),
										 repSustanciaActiva.getOne((long) 6))));
		repPlagas.save(new Plaga("Trips","Hercinothrips femoralis",
				"http://plagas.es/trips", Arrays.asList(repSustanciaActiva.getOne((long) 7),
										 repSustanciaActiva.getOne((long) 8),
										 repSustanciaActiva.getOne((long) 18))));
		repPlagas.save(new Plaga("Ácaro púrpura","Calacarus carinatus",
				"http://plagas.es/acaroPurpura", Arrays.asList(repSustanciaActiva.getOne((long) 9),
										 repSustanciaActiva.getOne((long) 10),
										 repSustanciaActiva.getOne((long) 19))));
		repPlagas.save(new Plaga("Minador sudamericano","Liriomyza huidobrensis",
				"http://plagas.es/minador", Arrays.asList(repSustanciaActiva.getOne((long) 11),
										 repSustanciaActiva.getOne((long) 12),
										 repSustanciaActiva.getOne((long) 20),
										 repSustanciaActiva.getOne((long) 4),
										 repSustanciaActiva.getOne((long) 6),
										 repSustanciaActiva.getOne((long) 8))));
		repPlagas.save(new Plaga("Cotonet de les Valls","Delottococcus aberiae",
				"http://plagas.es/cotonet", Arrays.asList(repSustanciaActiva.getOne((long) 13),
										 repSustanciaActiva.getOne((long) 14),
										 repSustanciaActiva.getOne((long) 21))));
		repPlagas.save(new Plaga("Drosófila de alas manchadas","Drosophila suzukii",
				"http://plagas.es/drosofila", Arrays.asList(repSustanciaActiva.getOne((long) 15),
										 repSustanciaActiva.getOne((long) 16),
										 repSustanciaActiva.getOne((long) 22),
										 repSustanciaActiva.getOne((long) 7))));
		repPlagas.save(new Plaga("Pulgón","Aphididae",
				"http://plagas.es/pulgon", Arrays.asList(repSustanciaActiva.getOne((long) 17),
										 repSustanciaActiva.getOne((long) 18),
										 repSustanciaActiva.getOne((long) 13))));
		repPlagas.save(new Plaga("Cigarrita de espuma","Aphrophora salicina",
				"http://plagas.es/espuma", Arrays.asList(repSustanciaActiva.getOne((long) 19),
										 repSustanciaActiva.getOne((long) 20),
										 repSustanciaActiva.getOne((long) 14),
										 repSustanciaActiva.getOne((long) 12),
										 repSustanciaActiva.getOne((long) 13))));
		repPlagas.save(new Plaga("Mosquito de las agallas","Mikiola fagi",
				"http://plagas.es/agallas", Arrays.asList(repSustanciaActiva.getOne((long) 1),
										 repSustanciaActiva.getOne((long) 2),
										 repSustanciaActiva.getOne((long) 15))));
		repPlagas.save(new Plaga("Polilla leopardo","Zeuzera pyrina",
				"http://plagas.es/leopardo", Arrays.asList(repSustanciaActiva.getOne((long) 3),
										 repSustanciaActiva.getOne((long) 4),
										 repSustanciaActiva.getOne((long) 16),
										 repSustanciaActiva.getOne((long) 7),
										 repSustanciaActiva.getOne((long) 9))));
		repPlagas.save(new Plaga("Gorgojo perforador de los chopos","Cryptorhynchus lapathi",
				"http://plagas.es/gorgojo", Arrays.asList(repSustanciaActiva.getOne((long) 5),
										 repSustanciaActiva.getOne((long) 6),
										 repSustanciaActiva.getOne((long) 17))));
	}
	
	@GetMapping("/")
    private ResponseEntity<List<Plaga>> getPlagas() {
        return new ResponseEntity<List<Plaga>>(repPlagas.findAll(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Plaga> getPlaga(@PathVariable String id) {
		Optional<Plaga> opt = repPlagas.findById(Long.parseLong(id));
        if (opt.isPresent()) {
            return new ResponseEntity<Plaga>(opt.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Plaga>(HttpStatus.NOT_FOUND);
        }
	}
}
