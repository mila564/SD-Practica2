package sd.urjc.proyecto.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Especie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String nombreVulgar;
	private String nombreCientifico;
	@ManyToMany
	private List<Plaga> posiblesPlagas;

	public Especie() {}
	public Especie(String nombreVulgar, String nombreCientifico, List<Plaga> posiblesPlagas) {
		this.nombreVulgar = nombreVulgar;
		this.nombreCientifico = nombreCientifico;
		this.posiblesPlagas = posiblesPlagas;
	}
	public String getNombreVulgar() {
		return nombreVulgar;
	}
	public void setNombreVulgar(String nombreVulgar) {
		this.nombreVulgar = nombreVulgar;
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	public List<Plaga> getPosiblesPlagas() {
		return posiblesPlagas;
	}
	public void setPosiblesPlagas(List<Plaga> posiblesPlagas) {
		this.posiblesPlagas = posiblesPlagas;
	}
}