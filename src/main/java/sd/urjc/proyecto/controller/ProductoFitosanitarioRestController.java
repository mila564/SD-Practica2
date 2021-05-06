package sd.urjc.proyecto.controller;

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

import sd.urjc.proyecto.model.ProductoFitosanitario;
import sd.urjc.proyecto.repository.ProductoFitosanitarioRepository;

@RestController
@RequestMapping("/productos")
public class ProductoFitosanitarioRestController {

	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	@PostConstruct
	public void init() {
		repProductos.save(new ProductoFitosanitario("Microthiol Special Disperss", "http://productos.es/microthiol"));
		repProductos.save(new ProductoFitosanitario("Cobre Nordox 50", "http://productos.es/nordox"));
		repProductos.save(new ProductoFitosanitario("Deccosol MF", "http://productos.es/deccosol"));
		repProductos.save(new ProductoFitosanitario("Basagran L", "http://productos.es/basagran"));
		repProductos.save(new ProductoFitosanitario("Cuperval", "http://productos.es/cuperval"));
		repProductos.save(new ProductoFitosanitario("Microtox", "http://productos.es/microtox"));
		repProductos.save(new ProductoFitosanitario("Ever transparente", "http://productos.es/ever"));
		repProductos.save(new ProductoFitosanitario("Nufo-Z", "http://productos.es/nufo"));
		repProductos.save(new ProductoFitosanitario("Banvel D", "http://productos.es/banvel"));
		repProductos.save(new ProductoFitosanitario("Quilan", "http://productos.es/quilan"));
		repProductos.save(new ProductoFitosanitario("Venzar", "http://productos.es/venzar"));
		repProductos.save(new ProductoFitosanitario("Vydate 10 G", "http://productos.es/vydate"));
		repProductos.save(new ProductoFitosanitario("Beltasur 500", "http://productos.es/beltasur"));
		repProductos.save(new ProductoFitosanitario("Captana", "http://productos.es/captana"));
		repProductos.save(new ProductoFitosanitario("Caldo Bordeles MAC 80", "http://productos.es/bordeles"));
		repProductos.save(new ProductoFitosanitario("Metenal", "http://productos.es/metenal"));
		repProductos.save(new ProductoFitosanitario("Fulmit", "http://productos.es/fulmit"));
		repProductos.save(new ProductoFitosanitario("Aphox", "http://productos.es/aphox"));
		repProductos.save(new ProductoFitosanitario("Captagrex 80", "http://productos.es/captagrex"));
		repProductos.save(new ProductoFitosanitario("Ditiver C PM", "http://productos.es/ditiver"));
		repProductos.save(new ProductoFitosanitario("Azufre Famolins", "http://productos.es/azufre"));
		repProductos.save(new ProductoFitosanitario("Volck Verano", "http://productos.es/volck"));
		repProductos.save(new ProductoFitosanitario("Sanagricola WP", "http://productos.es/sanagricola"));
		repProductos.save(new ProductoFitosanitario("Capteran 50", "http://productos.es/capteran"));
		repProductos.save(new ProductoFitosanitario("Pelt 50 SC", "http://productos.es/pelt"));
		repProductos.save(new ProductoFitosanitario("Actellic 50 E", "http://productos.es/actellic"));
		repProductos.save(new ProductoFitosanitario("Agral", "http://productos.es/agral"));
		repProductos.save(new ProductoFitosanitario("Limagram", "http://productos.es/limagram"));
		repProductos.save(new ProductoFitosanitario("Cuprebel", "http://productos.es/cuprebel"));
		repProductos.save(new ProductoFitosanitario("Elogium", "http://productos.es/elogium"));
		repProductos.save(new ProductoFitosanitario("Supramin 20", "http://productos.es/supramin"));
	}
	
	@GetMapping("/")
    private ResponseEntity<List<ProductoFitosanitario>> getProductos() {
        return new ResponseEntity<List<ProductoFitosanitario>>(repProductos.findAll(), HttpStatus.OK);
    }
	
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
