package sd.urjc.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.urjc.proyecto.model.ProductoFitosanitario;
import sd.urjc.proyecto.repository.ProductoFitosanitarioRepository;

@RestController
@RequestMapping("/productos")
public class ProductoFitosanitarioRestController {

	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductoFitosanitario> getProducto(@PathVariable String id){
		Optional<ProductoFitosanitario> opt = repProductos.findById(Long.parseLong(id));
		if (opt.isPresent()) {
			return new ResponseEntity<ProductoFitosanitario>(opt.get(), HttpStatus.OK);
		}
		else{
			return new ResponseEntity<ProductoFitosanitario>(HttpStatus.NOT_FOUND);
		}
	}
}
