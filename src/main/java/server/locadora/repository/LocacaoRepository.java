package server.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.locadora.domain.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
