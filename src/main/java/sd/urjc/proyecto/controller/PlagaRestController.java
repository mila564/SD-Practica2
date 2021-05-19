package sd.urjc.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.urjc.proyecto.model.Plaga;
import sd.urjc.proyecto.model.ProductoFitosanitario;
import sd.urjc.proyecto.model.SustanciaActiva;
import sd.urjc.proyecto.repository.PlagaRepository;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/plagas")
public class PlagaRestController {
	
	@Autowired
	private PlagaRepository repPlagas;
		
	@GetMapping(value = "/{nombreVulgar}")
	public ResponseEntity<Plaga> getPlaga(@PathVariable String nombreVulgar) {
		Optional<Plaga> opt = repPlagas.findByNombreVulgar(nombreVulgar);
        if (opt.isPresent()) {
        	Plaga plaga = opt.get();
        	for (SustanciaActiva s : plaga.getSustanciasActivas()) {
        		s.setProductos(new ArrayList<ProductoFitosanitario>());
        	}
            return new ResponseEntity<Plaga>(plaga, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Plaga>(HttpStatus.NOT_FOUND);
        }
	}
	
}
