package sd.urjc.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sd.urjc.proyecto.model.SustanciaActiva;

@Service
public interface SustanciaActivaRepository extends JpaRepository<SustanciaActiva, Long> {
	Optional<SustanciaActiva> findById(Long id);
	SustanciaActiva findByNombre(String nombre);
}
