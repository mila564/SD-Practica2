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

import sd.urjc.proyecto.model.CategoriaCultivo;
import sd.urjc.proyecto.repository.CategoriaCultivoRepository;
import sd.urjc.proyecto.repository.EspecieRepository;

@RequestMapping("/categoriaCultivo")
@RestController
public class CategoriaCultivoController {
	@Autowired
	private CategoriaCultivoRepository repCategoriaCultivo;
	
	@Autowired
	private EspecieRepository repEspecie;
	
	@PostConstruct
	public void init() {
		repCategoriaCultivo.save(new CategoriaCultivo("Frutales", Arrays.asList(
				repEspecie.getOne((long)1),
				repEspecie.getOne((long)2)
				)));
		repCategoriaCultivo.save(new CategoriaCultivo("Hortalizas", Arrays.asList(
				repEspecie.getOne((long)3),
				repEspecie.getOne((long)4),
				repEspecie.getOne((long)1)
				)));
		repCategoriaCultivo.save(new CategoriaCultivo("Cereales", Arrays.asList(
				repEspecie.getOne((long)5),
				repEspecie.getOne((long)6),
				repEspecie.getOne((long)1)
				)));
		repCategoriaCultivo.save(new CategoriaCultivo("Oleaginosas", Arrays.asList(
				repEspecie.getOne((long)7),
				repEspecie.getOne((long)8)
				)));
	}
	
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
	
	@GetMapping("/")
	public ResponseEntity<List<CategoriaCultivo>> getCategoriasCultivo(){
		List<CategoriaCultivo> categorias = repCategoriaCultivo.findAll();
		return new ResponseEntity<List<CategoriaCultivo>>(categorias, HttpStatus.OK);
	}
	
	
}
