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

import sd.urjc.proyecto.model.CategoriaCultivo;
import sd.urjc.proyecto.repository.CategoriaCultivoRepository;

@RequestMapping("/categoriaCultivo")
@RestController
public class CategoriaCultivoController {
	@Autowired
	private CategoriaCultivoRepository repCategoriaCultivo;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaCultivo>getCategoriaCultivo(@PathVariable("id") String id){
		Optional<CategoriaCultivo> categoria = repCategoriaCultivo.findById(Long.parseLong(id));
		if(categoria.isPresent()) {
			return new ResponseEntity<CategoriaCultivo>(categoria.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<CategoriaCultivo>(HttpStatus.NOT_FOUND);
		}
	}
}