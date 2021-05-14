package sd.urjc.proyecto;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sd.urjc.proyecto.model.CategoriaCultivo;
import sd.urjc.proyecto.model.Especie;
import sd.urjc.proyecto.model.Plaga;
import sd.urjc.proyecto.model.ProductoFitosanitario;
import sd.urjc.proyecto.model.SustanciaActiva;
import sd.urjc.proyecto.repository.CategoriaCultivoRepository;
import sd.urjc.proyecto.repository.EspecieRepository;
import sd.urjc.proyecto.repository.PlagaRepository;
import sd.urjc.proyecto.repository.ProductoFitosanitarioRepository;
import sd.urjc.proyecto.repository.SustanciaActivaRepository;

@Component
public class DatabaseInitializer {
	@Autowired
	private CategoriaCultivoRepository repCategoriaCultivo;
	@Autowired
	private EspecieRepository repEspecies;
	@Autowired
	private PlagaRepository repPlagas;
	@Autowired
	private SustanciaActivaRepository repSustanciaActiva;
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	@PostConstruct
	public void init() {
		
		// Productos fitosanitarios
		
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
		
		// Sustancias activas
		
		repSustanciaActiva.save(new SustanciaActiva("8-hidroxiquinoleina", Arrays.asList(
				repProductos.findByNombre("Microthiol Special Disperss").get(),
				repProductos.findByNombre("Cobre Nordox 50").get(),
				repProductos.findByNombre("Deccosol MF").get(),
				repProductos.findByNombre("Basagran L").get(),
				repProductos.findByNombre("Cuperval").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("24-epibrasilonida",Arrays.asList(
				repProductos.findByNombre("Microthiol Special Disperss").get(),
				repProductos.findByNombre("Cobre Nordox 50").get(),
				repProductos.findByNombre("Deccosol MF").get(),
				repProductos.findByNombre("Basagran L").get(),
				repProductos.findByNombre("Cuperval").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aceite de naranja",Arrays.asList(
				repProductos.findByNombre("Microtox").get(),
				repProductos.findByNombre("Ever transparente").get(),
				repProductos.findByNombre("Nufo-Z").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aceite de parafina",Arrays.asList(
				repProductos.findByNombre("Quilan").get(),
				repProductos.findByNombre("Venzar").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acetaton amónico",Arrays.asList(
				repProductos.findByNombre("Vydate 10 G").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acibenzolar-s-metil",Arrays.asList(
				repProductos.findByNombre("Beltasur 500").get(),
				repProductos.findByNombre("Captana").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido acético",Arrays.asList(
				repProductos.findByNombre("Caldo Bordeles MAC 80").get(),
				repProductos.findByNombre("Metenal").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido L-ascórbico",Arrays.asList(
				repProductos.findByNombre("Fulmit").get(),
				repProductos.findByNombre("Aphox").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido S-abscísico",Arrays.asList(
				repProductos.findByNombre("Captagrex 80").get(),
				repProductos.findByNombre("Ditiver C PM").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido benzoico",Arrays.asList(
				repProductos.findByNombre("Azufre Famolins").get(),
				repProductos.findByNombre("Volck Verano").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Ácido gilberélico",Arrays.asList(
				repProductos.findByNombre("Sanagricola WP").get(),
				repProductos.findByNombre("Capteran 50").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aclonifen",Arrays.asList(
				repProductos.findByNombre("Pelt 50 SC").get(),
				repProductos.findByNombre("Actellic 50 E").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Acrinatrin",Arrays.asList(
				repProductos.findByNombre("Agral").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Alfa cipermetrina",Arrays.asList(
				repProductos.findByNombre("Limagram").get(),
				repProductos.findByNombre("Cuprebel").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Amidosulfurón",Arrays.asList(
				repProductos.findByNombre("Elogium").get(),
				repProductos.findByNombre("Supramin 20").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aminopiralida",Arrays.asList(
				repProductos.findByNombre("Captagrex 80").get(),
				repProductos.findByNombre("Ditiver C PM").get(),
				repProductos.findByNombre("Azufre Famolins").get(),
				repProductos.findByNombre("Ditiver C PM").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Amepelomyces quisqualis",Arrays.asList(
				repProductos.findByNombre("Fulmit").get(),
				repProductos.findByNombre("Ditiver C PM").get(),
				repProductos.findByNombre("Sanagricola WP").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Azimsulfurón",Arrays.asList(
				repProductos.findByNombre("Ever transparente").get(),
				repProductos.findByNombre("Banvel D").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Aureobasidium pullulans",Arrays.asList(
				repProductos.findByNombre("Quilan").get()
				)));
		repSustanciaActiva.save(new SustanciaActiva("Arena de cuarzo",Arrays.asList(
				repProductos.findByNombre("Vydate 10 G").get(),
				repProductos.findByNombre("Venzar").get(),
				repProductos.findByNombre("Metenal").get(),
				repProductos.findByNombre("Fulmit").get(),
				repProductos.findByNombre("Vydate 10 G").get(),
				repProductos.findByNombre("Caldo Bordeles MAC 80").get()
				)));
		
		// Plagas
		
		repPlagas.save(new Plaga("Polilla del aliso","Acronicta alni",
				"http://plagas.es/aliso", Arrays.asList(repSustanciaActiva.findByNombre("8-hidroxiquinoleina").get(),
										 repSustanciaActiva.findByNombre("24-epibrasilonida").get(),
										 repSustanciaActiva.findByNombre("Aceite de naranja").get(),
										 repSustanciaActiva.findByNombre("Aceite de parafina").get())));
		repPlagas.save(new Plaga("Oruga de zurrón","Euproctis chrysorrhoea",
				"http://plagas.es/zurron", Arrays.asList(repSustanciaActiva.findByNombre("Acetaton amónico").get(),
										 repSustanciaActiva.findByNombre("Acibenzolar-s-metil").get(),
										 repSustanciaActiva.findByNombre("Ácido acético").get(),
										 repSustanciaActiva.findByNombre("Ácido L-ascórbico").get(),
										 repSustanciaActiva.findByNombre("Ácido S-abscísico").get())));
		repPlagas.save(new Plaga("Pájaro luna","Phalera bucephala",
				"http://plagas.es/luna", Arrays.asList(repSustanciaActiva.findByNombre("Ácido benzoico").get(),
										 repSustanciaActiva.findByNombre("Ácido gilberélico").get(),
										 repSustanciaActiva.findByNombre("Aclonifen").get())));
		repPlagas.save(new Plaga("Piojo Rojo de California","Aonidiella auranti",
				"http://plagas.es/piojoRojo", Arrays.asList(repSustanciaActiva.findByNombre("Acrinatrin").get(),
										 repSustanciaActiva.findByNombre("Alfa cipermetrina").get(),
										 repSustanciaActiva.findByNombre("Amidosulfurón").get(),
										 repSustanciaActiva.findByNombre("Aminopiralida").get())));
		repPlagas.save(new Plaga("Mosca blanca","Bemisia tabaci",
				"http://plagas.es/moscaBlanca", Arrays.asList(repSustanciaActiva.findByNombre("Amepelomyces quisqualis").get())));
		repPlagas.save(new Plaga("Escarabajo Khapra","Trogoderma granarium",
				"http://plagas.es/khapra", Arrays.asList(repSustanciaActiva.findByNombre("Azimsulfurón").get(),
										 repSustanciaActiva.findByNombre("Aureobasidium pullulans").get(),
										 repSustanciaActiva.findByNombre("Arena de cuarzo").get(),
										 repSustanciaActiva.findByNombre("8-hidroxiquinoleina").get())));
		repPlagas.save(new Plaga("Trips","Hercinothrips femoralis",
				"http://plagas.es/trips", Arrays.asList(repSustanciaActiva.findByNombre("24-epibrasilonida").get(),
										 repSustanciaActiva.findByNombre("Aceite de naranja").get(),
										 repSustanciaActiva.findByNombre("Aceite de parafina").get())));
		repPlagas.save(new Plaga("Ácaro púrpura","Calacarus carinatus",
				"http://plagas.es/acaroPurpura", Arrays.asList(repSustanciaActiva.findByNombre("Acetaton amónico").get(),
										 repSustanciaActiva.findByNombre("Acibenzolar-s-metil").get(),
										 repSustanciaActiva.findByNombre("Ácido acético").get())));
		repPlagas.save(new Plaga("Minador sudamericano","Liriomyza huidobrensis",
				"http://plagas.es/minador", Arrays.asList(repSustanciaActiva.findByNombre("Ácido L-ascórbico").get(),
									 	 repSustanciaActiva.findByNombre("Ácido S-abscísico").get(),
									 	 repSustanciaActiva.findByNombre("Ácido benzoico").get(),
									 	 repSustanciaActiva.findByNombre("Ácido gilberélico").get(),
									 	 repSustanciaActiva.findByNombre("Aclonifen").get(),
									 	 repSustanciaActiva.findByNombre("Acrinatrin").get())));
		repPlagas.save(new Plaga("Cotonet de les Valls","Delottococcus aberiae",
				"http://plagas.es/cotonet", Arrays.asList(repSustanciaActiva.findByNombre("Alfa cipermetrina").get(),
										 repSustanciaActiva.findByNombre("Amidosulfurón").get(),
										 repSustanciaActiva.findByNombre("Aminopiralida").get())));
		repPlagas.save(new Plaga("Drosófila de alas manchadas","Drosophila suzukii",
				"http://plagas.es/drosofila", Arrays.asList(repSustanciaActiva.findByNombre("Amepelomyces quisqualis").get(),
										 repSustanciaActiva.findByNombre("Azimsulfurón").get(),
										 repSustanciaActiva.findByNombre("Aureobasidium pullulans").get(),
										 repSustanciaActiva.findByNombre("Arena de cuarzo").get())));
		repPlagas.save(new Plaga("Pulgón","Aphididae",
				"http://plagas.es/pulgon", Arrays.asList(repSustanciaActiva.findByNombre("8-hidroxiquinoleina").get(),
										 repSustanciaActiva.findByNombre("24-epibrasilonida").get(),
										 repSustanciaActiva.findByNombre("Aceite de naranja").get())));
		repPlagas.save(new Plaga("Cigarrita de espuma","Aphrophora salicina",
				"http://plagas.es/espuma", Arrays.asList(repSustanciaActiva.findByNombre("Aceite de parafina").get(),
										 repSustanciaActiva.findByNombre("Acetaton amónico").get(),
										 repSustanciaActiva.findByNombre("Acibenzolar-s-metil").get(),
										 repSustanciaActiva.findByNombre("Ácido acético").get(),
										 repSustanciaActiva.findByNombre("Ácido L-ascórbico").get())));
		repPlagas.save(new Plaga("Mosquito de las agallas","Mikiola fagi",
				"http://plagas.es/agallas", Arrays.asList(repSustanciaActiva.findByNombre("Ácido S-abscísico").get(),
										 repSustanciaActiva.findByNombre("Ácido benzoico").get(),
										 repSustanciaActiva.findByNombre("Ácido gilberélico").get())));
		repPlagas.save(new Plaga("Polilla leopardo","Zeuzera pyrina",
				"http://plagas.es/leopardo", Arrays.asList(repSustanciaActiva.findByNombre("Aclonifen").get(),
										 repSustanciaActiva.findByNombre("Acrinatrin").get(),
										 repSustanciaActiva.findByNombre("Alfa cipermetrina").get(),
										 repSustanciaActiva.findByNombre("Amidosulfurón").get(),
										 repSustanciaActiva.findByNombre("Aminopiralida").get())));
		repPlagas.save(new Plaga("Gorgojo perforador de los chopos","Cryptorhynchus lapathi",
				"http://plagas.es/gorgojo", Arrays.asList(repSustanciaActiva.findByNombre("Amepelomyces quisqualis").get(),
										 repSustanciaActiva.findByNombre("Azimsulfurón").get(),
										 repSustanciaActiva.findByNombre("Aureobasidium pullulans").get())));
		
		// Especies
		
		repEspecies.save(new Especie("Manzano", "Malus domestica", Arrays.asList(repPlagas.findByNombreVulgar("Polilla del aliso").get(), repPlagas.findByNombreVulgar("Oruga de zurrón").get(), repPlagas.findByNombreVulgar("Cigarrita de espuma").get())));
		repEspecies.save(new Especie("Peral", "Pyrus communis", Arrays.asList(repPlagas.findByNombreVulgar("Polilla del aliso").get(), repPlagas.findByNombreVulgar("Oruga de zurrón").get(), repPlagas.findByNombreVulgar("Mosquito de las agallas").get())));
		repEspecies.save(new Especie("Naranjo", "Citrus sinensis", Arrays.asList(repPlagas.findByNombreVulgar("Polilla del aliso").get(), repPlagas.findByNombreVulgar("Pájaro luna").get(), repPlagas.findByNombreVulgar("Polilla leopardo").get())));
		repEspecies.save(new Especie("Fresa", "Fragaria Ananassa", Arrays.asList(repPlagas.findByNombreVulgar("Piojo Rojo de California").get(), repPlagas.findByNombreVulgar("Pájaro luna").get(), repPlagas.findByNombreVulgar("Gorgojo perforador de los chopos").get())));
		repEspecies.save(new Especie("Vid", "Vitis vinifera", Arrays.asList(repPlagas.findByNombreVulgar("Mosca blanca").get(), repPlagas.findByNombreVulgar("Escarabajo Khapra").get())));
		repEspecies.save(new Especie("Alcachofa", "Cynara scolymus", Arrays.asList(repPlagas.findByNombreVulgar("Trips").get(), repPlagas.findByNombreVulgar("Ácaro púrpura").get())));
		repEspecies.save(new Especie("Lechuga", "Lactuca sativa", Arrays.asList(repPlagas.findByNombreVulgar("Minador sudamericano").get(), repPlagas.findByNombreVulgar("Cotonet de les Valls").get())));
		repEspecies.save(new Especie("Cacahuete", "Arachis hypogaea", Arrays.asList(repPlagas.findByNombreVulgar("Drosófila de alas manchadas").get(), repPlagas.findByNombreVulgar("Pulgón").get())));
		
		// Categorías de cultivo
		
		repCategoriaCultivo.save(new CategoriaCultivo("Frutales", Arrays.asList(
				repEspecies.findByNombreVulgar("Manzano").get(),
				repEspecies.findByNombreVulgar("Peral").get()
				)));
		repCategoriaCultivo.save(new CategoriaCultivo("Hortalizas", Arrays.asList(
				repEspecies.findByNombreVulgar("Fresa").get(),
				repEspecies.findByNombreVulgar("Naranjo").get(),
				repEspecies.findByNombreVulgar("Vid").get()
				)));
		repCategoriaCultivo.save(new CategoriaCultivo("Cereales", Arrays.asList(
				repEspecies.findByNombreVulgar("Cacahuete").get(),
				repEspecies.findByNombreVulgar("Lechuga").get(),
				repEspecies.findByNombreVulgar("Alcachofa").get()
				)));
		repCategoriaCultivo.save(new CategoriaCultivo("Oleaginosas", Arrays.asList(
				repEspecies.findByNombreVulgar("Alcachofa").get(),
				repEspecies.findByNombreVulgar("Cacahuete").get()
				)));
	}	
	
}
