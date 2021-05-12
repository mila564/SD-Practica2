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
				"http://plagas.es/aliso", Arrays.asList(repSustanciaActiva.findByNombre("8-hidroxiquinoleina").get(),
										 repSustanciaActiva.findByNombre("24-epibrasilonida").get(),
										 repSustanciaActiva.findByNombre("Aceite de naranja").get(),
										 repSustanciaActiva.findByNombre("Aceite de parafina").get())));
		repPlagas.save(new Plaga("Oruga de zurrón","Euproctis chrysorrhoea",
				"http://plagas.es/zurron", Arrays.asList(repSustanciaActiva.findByNombre("Acetaton amónico").get(),
										 repSustanciaActiva.findByNombre("Acibenzolar-s-metil").get(),
										 repSustanciaActiva.findByNombre("Ácido acético").get(),
										 repSustanciaActiva.findByNombre("Ácido L-ascórbico").get(),
										 repSustanciaActiva.findByNombre("Ácido S-abscísico").get())));
		repPlagas.save(new Plaga("Pájaro luna","Phalera bucephala",
				"http://plagas.es/luna", Arrays.asList(repSustanciaActiva.findByNombre("Ácido benzoico").get(),
										 repSustanciaActiva.findByNombre("Ácido gilberélico").get(),
										 repSustanciaActiva.findByNombre("Aclonifen").get())));
		repPlagas.save(new Plaga("Piojo Rojo de California","Aonidiella auranti",
				"http://plagas.es/piojoRojo", Arrays.asList(repSustanciaActiva.findByNombre("Acrinatrin").get(),
										 repSustanciaActiva.findByNombre("Alfa cipermetrina").get(),
										 repSustanciaActiva.findByNombre("Amidosulfurón").get(),
										 repSustanciaActiva.findByNombre("Aminopiralida").get())));
		repPlagas.save(new Plaga("Mosca blanca","Bemisia tabaci",
				"http://plagas.es/moscaBlanca", Arrays.asList(repSustanciaActiva.findByNombre("Amepelomyces quisqualis").get())));
		repPlagas.save(new Plaga("Escarabajo Khapra","Trogoderma granarium",
				"http://plagas.es/khapra", Arrays.asList(repSustanciaActiva.findByNombre("Azimsulfurón").get(),
										 repSustanciaActiva.findByNombre("Aureobasidium pullulans").get(),
										 repSustanciaActiva.findByNombre("Arena de cuarzo").get(),
										 repSustanciaActiva.findByNombre("8-hidroxiquinoleina").get())));
		repPlagas.save(new Plaga("Trips","Hercinothrips femoralis",
				"http://plagas.es/trips", Arrays.asList(repSustanciaActiva.findByNombre("24-epibrasilonida").get(),
										 repSustanciaActiva.findByNombre("Aceite de naranja").get(),
										 repSustanciaActiva.findByNombre("Aceite de parafina").get())));
		repPlagas.save(new Plaga("Ácaro púrpura","Calacarus carinatus",
				"http://plagas.es/acaroPurpura", Arrays.asList(repSustanciaActiva.findByNombre("Acetaton amónico").get(),
										 repSustanciaActiva.findByNombre("Acibenzolar-s-metil").get(),
										 repSustanciaActiva.findByNombre("Ácido acético").get())));
		repPlagas.save(new Plaga("Minador sudamericano","Liriomyza huidobrensis",
				"http://plagas.es/minador", Arrays.asList(repSustanciaActiva.findByNombre("Ácido L-ascórbico").get(),
									 	 repSustanciaActiva.findByNombre("Ácido S-abscísico").get(),
									 	 repSustanciaActiva.findByNombre("Ácido benzoico").get(),
									 	 repSustanciaActiva.findByNombre("Ácido gilberélico").get(),
									 	 repSustanciaActiva.findByNombre("Aclonifen").get(),
									 	 repSustanciaActiva.findByNombre("Acrinatrin").get())));
		repPlagas.save(new Plaga("Cotonet de les Valls","Delottococcus aberiae",
				"http://plagas.es/cotonet", Arrays.asList(repSustanciaActiva.findByNombre("Alfa cipermetrina").get(),
										 repSustanciaActiva.findByNombre("Amidosulfurón").get(),
										 repSustanciaActiva.findByNombre("Aminopiralida").get())));
		repPlagas.save(new Plaga("Drosófila de alas manchadas","Drosophila suzukii",
				"http://plagas.es/drosofila", Arrays.asList(repSustanciaActiva.findByNombre("Amepelomyces quisqualis").get(),
										 repSustanciaActiva.findByNombre("Azimsulfurón").get(),
										 repSustanciaActiva.findByNombre("Aureobasidium pullulans").get(),
										 repSustanciaActiva.findByNombre("Arena de cuarzo").get())));
		repPlagas.save(new Plaga("Pulgón","Aphididae",
				"http://plagas.es/pulgon", Arrays.asList(repSustanciaActiva.findByNombre("8-hidroxiquinoleina").get(),
										 repSustanciaActiva.findByNombre("24-epibrasilonida").get(),
										 repSustanciaActiva.findByNombre("Aceite de naranja").get())));
		repPlagas.save(new Plaga("Cigarrita de espuma","Aphrophora salicina",
				"http://plagas.es/espuma", Arrays.asList(repSustanciaActiva.findByNombre("Aceite de parafina").get(),
										 repSustanciaActiva.findByNombre("Acetaton amónico").get(),
										 repSustanciaActiva.findByNombre("Acibenzolar-s-metil").get(),
										 repSustanciaActiva.findByNombre("Ácido acético").get(),
										 repSustanciaActiva.findByNombre("Ácido L-ascórbico").get())));
		repPlagas.save(new Plaga("Mosquito de las agallas","Mikiola fagi",
				"http://plagas.es/agallas", Arrays.asList(repSustanciaActiva.findByNombre("Ácido S-abscísico").get(),
										 repSustanciaActiva.findByNombre("Ácido benzoico").get(),
										 repSustanciaActiva.findByNombre("Ácido gilberélico").get())));
		repPlagas.save(new Plaga("Polilla leopardo","Zeuzera pyrina",
				"http://plagas.es/leopardo", Arrays.asList(repSustanciaActiva.findByNombre("Aclonifen").get(),
										 repSustanciaActiva.findByNombre("Acrinatrin").get(),
										 repSustanciaActiva.findByNombre("Alfa cipermetrina").get(),
										 repSustanciaActiva.findByNombre("Amidosulfurón").get(),
										 repSustanciaActiva.findByNombre("Aminopiralida").get())));
		repPlagas.save(new Plaga("Gorgojo perforador de los chopos","Cryptorhynchus lapathi",
				"http://plagas.es/gorgojo", Arrays.asList(repSustanciaActiva.findByNombre("Amepelomyces quisqualis").get(),
										 repSustanciaActiva.findByNombre("Azimsulfurón").get(),
										 repSustanciaActiva.findByNombre("Aureobasidium pullulans").get())));
	}
	
	@GetMapping("/")
    private ResponseEntity<List<Plaga>> getPlagas() {
        return new ResponseEntity<List<Plaga>>(repPlagas.findAll(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/{nombreVulgar}")
	public ResponseEntity<Plaga> getPlaga(@PathVariable String nombreVulgar) {
		Optional<Plaga> opt = repPlagas.findByNombreVulgar(nombreVulgar);
        if (opt.isPresent()) {
            return new ResponseEntity<Plaga>(opt.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Plaga>(HttpStatus.NOT_FOUND);
        }
	}
}
