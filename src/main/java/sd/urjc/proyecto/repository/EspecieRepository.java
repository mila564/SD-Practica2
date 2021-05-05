package sd.urjc.proyecto.repository;

import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import sd.urjc.proyecto.model.Especie;

import java.util.Optional;

@Service
public interface EspecieRepository extends JpaRepository<Especie, Long>{
	Optional<Especie> findByNombreVulgar(String nombreVulgar);
	Optional<Especie> findByNombreCientifico(String nombreCientifico);
}