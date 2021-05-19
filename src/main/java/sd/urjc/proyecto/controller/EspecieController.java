package sd.urjc.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import sd.urjc.proyecto.model.Especie;
import sd.urjc.proyecto.model.Plaga;
import sd.urjc.proyecto.model.SustanciaActiva;
import sd.urjc.proyecto.repository.EspecieRepository;

@Controller
@RequestMapping("/especies")
public class EspecieController {
	@Autowired
	private EspecieRepository repEspecies;
	
	@GetMapping("/{nombreVulgar}")
	private ResponseEntity<Especie> getEspecie(@PathVariable String nombreVulgar) {
		Optional<Especie> opt = repEspecies.findByNombreVulgar(nombreVulgar);
		if (opt.isPresent()) {
			Especie especie = opt.get();
			for (Plaga p : especie.getPosiblesPlagas()) {
				p.setSustanciasActivas(new ArrayList<SustanciaActiva>());
			}
			return new ResponseEntity<>(especie, HttpStatus.OK);			
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}