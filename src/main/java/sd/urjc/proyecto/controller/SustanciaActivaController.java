package sd.urjc.proyecto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.urjc.proyecto.model.SustanciaActiva;
import sd.urjc.proyecto.repository.ProductoFitosanitarioRepository;
import sd.urjc.proyecto.repository.SustanciaActivaRepository;

@RequestMapping("/sustanciaActiva")
@RestController
public class SustanciaActivaController {
	@Autowired
	private SustanciaActivaRepository repSustanciaActiva;
	@Autowired
	private ProductoFitosanitarioRepository repProductoFitosanitario;
	
	@PostConstruct
	public void init() {
		repSustanciaActiva.save(new SustanciaActiva("8-hidroxiquinoleina", Arrays.asList(
				repProductoFitosanitario.getOne((long)1),
				repProductoFitosanitario.getOne((long)2),
				repProductoFitosanitario.getOne((long)3),
				repProductoFitosanitario.getOne((long)4),
				repProductoFitosanitario.getOne((long)5)
				)));
		repSustanciaActiva.save(new SustanciaActiva("24-epibrasilonida",Arrays.asList(
				repProductoFitosanitario.getOne((long)1),
				repProductoFitosanitario.getOne((long)2),
				repProductoFitosanitario.getOne((long)3),
				repProductoFitosanitario.getOne((long)4),
				repProductoFitosanitario.getOne((long)5)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aceite de naranja",Arrays.asList(
				repProductoFitosanitario.getOne((long)6),
				repProductoFitosanitario.getOne((long)7),
				repProductoFitosanitario.getOne((long)8)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aceite de parafina",Arrays.asList(
				repProductoFitosanitario.getOne((long)9),
				repProductoFitosanitario.getOne((long)10)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acetaton amónico",Arrays.asList(
				repProductoFitosanitario.getOne((long)9)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acibenzolar-s-metil",Arrays.asList(
				repProductoFitosanitario.getOne((long)11),
				repProductoFitosanitario.getOne((long)12))));
		repSustanciaActiva.save(new SustanciaActiva("Ácido acético",Arrays.asList(
				repProductoFitosanitario.getOne((long)13),
				repProductoFitosanitario.getOne((long)14)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido L-ascórbico",Arrays.asList(
				repProductoFitosanitario.getOne((long)15),
				repProductoFitosanitario.getOne((long)16)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido S-abscísico",Arrays.asList(
				repProductoFitosanitario.getOne((long)17),
				repProductoFitosanitario.getOne((long)18)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido benzoico",Arrays.asList(
				repProductoFitosanitario.getOne((long)19),
				repProductoFitosanitario.getOne((long)20)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido gilberélico",Arrays.asList(
				repProductoFitosanitario.getOne((long)21),
				repProductoFitosanitario.getOne((long)22)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aclonifen",Arrays.asList(
				repProductoFitosanitario.getOne((long)23),
				repProductoFitosanitario.getOne((long)24)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acrinatrin",Arrays.asList(
				repProductoFitosanitario.getOne((long)25),
				repProductoFitosanitario.getOne((long)26)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Alfa cipermetrina",Arrays.asList(
				repProductoFitosanitario.getOne((long)27),
				repProductoFitosanitario.getOne((long)28)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Amidosulfurón",Arrays.asList(
				repProductoFitosanitario.getOne((long)29),
				repProductoFitosanitario.getOne((long)30)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aminopiralida",Arrays.asList(
				repProductoFitosanitario.getOne((long)9),
				repProductoFitosanitario.getOne((long)8),
				repProductoFitosanitario.getOne((long)13),
				repProductoFitosanitario.getOne((long)14)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Amepelomyces quisqualis",Arrays.asList(
				repProductoFitosanitario.getOne((long)19),
				repProductoFitosanitario.getOne((long)25),
				repProductoFitosanitario.getOne((long)13)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Azimsulfurón",Arrays.asList(
				repProductoFitosanitario.getOne((long)23),
				repProductoFitosanitario.getOne((long)14)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aureobasidium pullulans",Arrays.asList(
				repProductoFitosanitario.getOne((long)1)
				)));
		repSustanciaActiva.save(new SustanciaActiva("Arena de cuarzo",Arrays.asList(
				repProductoFitosanitario.getOne((long)11),
				repProductoFitosanitario.getOne((long)22),
				repProductoFitosanitario.getOne((long)18),
				repProductoFitosanitario.getOne((long)2),
				repProductoFitosanitario.getOne((long)20),
				repProductoFitosanitario.getOne((long)15)
				)));

	}
	@GetMapping("/{id}")
	public ResponseEntity<SustanciaActiva> getSustanciaActiva(@PathVariable("id") String id){
		Optional<SustanciaActiva> sustanciaActiva = repSustanciaActiva.findById(Long.parseLong(id));
		if(sustanciaActiva.isPresent()) {
			return new ResponseEntity<SustanciaActiva>(sustanciaActiva.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<SustanciaActiva>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<SustanciaActiva>> getSustanciasActivas(){
		List<SustanciaActiva> sustanciasActivas = repSustanciaActiva.findAll();
		return new ResponseEntity<List<SustanciaActiva>>(sustanciasActivas, HttpStatus.OK);
	}
}
