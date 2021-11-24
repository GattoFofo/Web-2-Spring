package server.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.locadora.domain.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
