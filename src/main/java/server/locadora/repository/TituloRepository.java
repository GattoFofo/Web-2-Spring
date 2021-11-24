package server.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.locadora.domain.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Long> {
}
