package sd.urjc.proyecto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.urjc.proyecto.model.CategoriaCultivo;
import sd.urjc.proyecto.model.Especie;
import sd.urjc.proyecto.model.Plaga;
import sd.urjc.proyecto.repository.CategoriaCultivoRepository;

@RequestMapping("/categoriaCultivo")
@RestController
public class CategoriaCultivoController {
	@Autowired
	private CategoriaCultivoRepository repCategoriaCultivo;
	
	@GetMapping("/")
	public ResponseEntity<List<CategoriaCultivo>> getCategoriasCultivo(){
		List<CategoriaCultivo> categorias = repCategoriaCultivo.findAll();
		/*for (CategoriaCultivo c : categorias) {
			c.setEspecies(new ArrayList<Especie>());
		}*/
		return new ResponseEntity<List<CategoriaCultivo>>(categorias, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/{nombre}")
	public ResponseEntity<CategoriaCultivo>getCategoriaCultivo(@PathVariable("nombre") String nombre){
		Optional<CategoriaCultivo> opt = repCategoriaCultivo.findByNombre(nombre);
		if(opt.isPresent()) {
			CategoriaCultivo categoria = opt.get();
			for (Especie e : categoria.getEspecies()) {
				e.setPosiblesPlagas(new ArrayList<Plaga>());
			}
			return new ResponseEntity<CategoriaCultivo>(categoria, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<CategoriaCultivo>(HttpStatus.NOT_FOUND);
		}
	}
	
}
