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
				repProductoFitosanitario.findByNombre("Microthiol").get(),
				repProductoFitosanitario.findByNombre("Cobre Nordox 50").get(),
				repProductoFitosanitario.findByNombre("Deccosol MF").get(),
				repProductoFitosanitario.findByNombre("Basagran L").get(),
				repProductoFitosanitario.findByNombre("Cuperval").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("24-epibrasilonida",Arrays.asList(
				repProductoFitosanitario.findByNombre("Microthiol").get(),
				repProductoFitosanitario.findByNombre("Cobre Nordox 50").get(),
				repProductoFitosanitario.findByNombre("Deccosol MF").get(),
				repProductoFitosanitario.findByNombre("Basagran L").get(),
				repProductoFitosanitario.findByNombre("Cuperval").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aceite de naranja",Arrays.asList(
				repProductoFitosanitario.findByNombre("Microtox").get(),
				repProductoFitosanitario.findByNombre("Ever transparente").get(),
				repProductoFitosanitario.findByNombre("Nufo-Z").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aceite de parafina",Arrays.asList(
				repProductoFitosanitario.findByNombre("Quilan").get(),
				repProductoFitosanitario.findByNombre("Venzar").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acetaton amónico",Arrays.asList(
				repProductoFitosanitario.findByNombre("Vydate 10 G").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acibenzolar-s-metil",Arrays.asList(
				repProductoFitosanitario.findByNombre("Beltasur 500").get(),
				repProductoFitosanitario.findByNombre("Captana").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido acético",Arrays.asList(
				repProductoFitosanitario.findByNombre("Caldo Bordeles MAC 80").get(),
				repProductoFitosanitario.findByNombre("Metenal").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido L-ascórbico",Arrays.asList(
				repProductoFitosanitario.findByNombre("Fulmit").get(),
				repProductoFitosanitario.findByNombre("Aphox").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido S-abscísico",Arrays.asList(
				repProductoFitosanitario.findByNombre("Captagrex 80").get(),
				repProductoFitosanitario.findByNombre("Ditiver C PM").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido benzoico",Arrays.asList(
				repProductoFitosanitario.findByNombre("Azufre Famolins").get(),
				repProductoFitosanitario.findByNombre("Volck Verano").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido gilberélico",Arrays.asList(
				repProductoFitosanitario.findByNombre("Sanagricola WP").get(),
				repProductoFitosanitario.findByNombre("Capteran 50").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aclonifen",Arrays.asList(
				repProductoFitosanitario.findByNombre("Pelt 50 SC").get(),
				repProductoFitosanitario.findByNombre("Actellic 50 E").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acrinatrin",Arrays.asList(
				repProductoFitosanitario.findByNombre("Agral").get(),
				repProductoFitosanitario.findByNombre("").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Alfa cipermetrina",Arrays.asList(
				repProductoFitosanitario.findByNombre("Limagram").get(),
				repProductoFitosanitario.findByNombre("Cuprebel").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Amidosulfurón",Arrays.asList(
				repProductoFitosanitario.findByNombre("Elogium").get(),
				repProductoFitosanitario.findByNombre("Supramin 20").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aminopiralida",Arrays.asList(
				repProductoFitosanitario.findByNombre("Captagrex 80").get(),
				repProductoFitosanitario.findByNombre("Ditiver C PM").get(),
				repProductoFitosanitario.findByNombre("Azufre Famolins").get(),
				repProductoFitosanitario.findByNombre("Ditiver C PM").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Amepelomyces quisqualis",Arrays.asList(
				repProductoFitosanitario.findByNombre("Fulmit").get(),
				repProductoFitosanitario.findByNombre("Ditiver C PM").get(),
				repProductoFitosanitario.findByNombre("Sanagricola WP").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Azimsulfurón",Arrays.asList(
				repProductoFitosanitario.findByNombre("Ever transparente").get(),
				repProductoFitosanitario.findByNombre("Banvel D").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aureobasidium pullulans",Arrays.asList(
				repProductoFitosanitario.findByNombre("Quilan").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Arena de cuarzo",Arrays.asList(
				repProductoFitosanitario.findByNombre("Vydate 10 G").get(),
				repProductoFitosanitario.findByNombre("Venzar").get(),
				repProductoFitosanitario.findByNombre("Metenal").get(),
				repProductoFitosanitario.findByNombre("Fulmit").get(),
				repProductoFitosanitario.findByNombre("Vydate 10 G").get(),
				repProductoFitosanitario.findByNombre("Caldo Bordeles MAC 80").get()
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
