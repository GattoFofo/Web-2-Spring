package server.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.locadora.domain.Ator;

public interface AtorRepository extends JpaRepository<Ator, Long> {
}
