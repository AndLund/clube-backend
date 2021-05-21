package sistemas.logique.clube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemas.logique.clube.model.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {

}
