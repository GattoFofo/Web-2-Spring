package server.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.locadora.domain.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {
}
