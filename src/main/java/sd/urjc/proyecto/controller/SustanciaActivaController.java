package sd.urjc.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.urjc.proyecto.model.SustanciaActiva;
import sd.urjc.proyecto.repository.SustanciaActivaRepository;

@RequestMapping("/sustanciaActiva")
@RestController
public class SustanciaActivaController {
	@Autowired
	private SustanciaActivaRepository repSustanciaActiva;
	
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

}
