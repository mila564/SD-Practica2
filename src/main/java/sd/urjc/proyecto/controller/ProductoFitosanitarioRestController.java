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
		repProductos.save(new ProductoFitosanitario("MICROTHIOL SPECIAL DISPERSS", "http://productos.es/microthiol"));
		repProductos.save(new ProductoFitosanitario("COBRE NORDOX 50", "http://productos.es/nordox"));
		repProductos.save(new ProductoFitosanitario("DECCOSOL-MF", "http://productos.es/deccosol"));
		repProductos.save(new ProductoFitosanitario("BASAGRAN L", "http://productos.es/basagran"));
		repProductos.save(new ProductoFitosanitario("CUPERVAL", "http://productos.es/cuperval"));
		repProductos.save(new ProductoFitosanitario("MICROTOX", "http://productos.es/microtox"));
		repProductos.save(new ProductoFitosanitario("EVER TRANSPARENTE", "http://productos.es/ever"));
		repProductos.save(new ProductoFitosanitario("NUFO-Z", "http://productos.es/nufo"));
		repProductos.save(new ProductoFitosanitario("BANVEL-D", "http://productos.es/banvel"));
		repProductos.save(new ProductoFitosanitario("QUILAN", "http://productos.es/quilan"));
		repProductos.save(new ProductoFitosanitario("VENZAR", "http://productos.es/venzar"));
		repProductos.save(new ProductoFitosanitario("VYDATE 10 G", "http://productos.es/vydate"));
		repProductos.save(new ProductoFitosanitario("BELTASUR-500", "http://productos.es/beltasur"));
		repProductos.save(new ProductoFitosanitario("CAPTANA", "http://productos.es/captana"));
		repProductos.save(new ProductoFitosanitario("CALDO BORDELES MAC 80", "http://productos.es/bordeles"));
		repProductos.save(new ProductoFitosanitario("METENAL", "http://productos.es/metenal"));
		repProductos.save(new ProductoFitosanitario("FULMIT", "http://productos.es/fulmit"));
		repProductos.save(new ProductoFitosanitario("APHOX", "http://productos.es/aphox"));
		repProductos.save(new ProductoFitosanitario("CAPTAGREX 80", "http://productos.es/captagrex"));
		repProductos.save(new ProductoFitosanitario("DITIVER C PM", "http://productos.es/ditiver"));
		repProductos.save(new ProductoFitosanitario("AZUFRE FAMOLINS", "http://productos.es/azufre"));
		repProductos.save(new ProductoFitosanitario("VOLCK VERANO", "http://productos.es/volck"));
		repProductos.save(new ProductoFitosanitario("SANAGRICOLA WP", "http://productos.es/sanagricola"));
		repProductos.save(new ProductoFitosanitario("CAPTERAN 50", "http://productos.es/capteran"));
		repProductos.save(new ProductoFitosanitario("PELT 50 SC", "http://productos.es/pelt"));
		repProductos.save(new ProductoFitosanitario("ACTELLIC 50-E", "http://productos.es/actellic"));
		repProductos.save(new ProductoFitosanitario("AGRAL", "http://productos.es/agral"));
		repProductos.save(new ProductoFitosanitario("LIMAGRAM", "http://productos.es/limagram"));
		repProductos.save(new ProductoFitosanitario("CUPREBEL", "http://productos.es/cuprebel"));
		repProductos.save(new ProductoFitosanitario("ELOGIUM", "http://productos.es/elogium"));
		repProductos.save(new ProductoFitosanitario("SUPRAMIN 20", "http://productos.es/supramin"));
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
