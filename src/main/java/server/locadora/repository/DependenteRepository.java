package server.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.locadora.domain.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {
}
