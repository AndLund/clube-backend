package sistemas.logique.clube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemas.logique.clube.model.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {
}
