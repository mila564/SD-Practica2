package sd.urjc.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sd.urjc.proyecto.model.CategoriaCultivo;

@Service
public interface CategoriaCultivoRepository extends JpaRepository<CategoriaCultivo, Long> {
	Optional<CategoriaCultivo> findById(Long id);
	CategoriaCultivo findByNombre(String nombre);
}
