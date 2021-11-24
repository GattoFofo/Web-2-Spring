package server.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.locadora.domain.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
