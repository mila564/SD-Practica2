package sd.urjc.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sd.urjc.proyecto.model.ProductoFitosanitario;

@Service
public interface ProductoFitosanitarioRepository extends JpaRepository<ProductoFitosanitario, Long>{
	Optional<ProductoFitosanitario> findByNombre(String nombre);
}
