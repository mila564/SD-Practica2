package sd.urjc.proyecto.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SustanciaActiva {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nombre;
	@ManyToMany
	private List<ProductoFitosanitario> productos;
	
	
	public SustanciaActiva() {}

	public SustanciaActiva(String nombre, List<ProductoFitosanitario> productos) {
		this.nombre = nombre;
		this.productos = productos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ProductoFitosanitario> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoFitosanitario> productos) {
		this.productos = productos;
	}
}
