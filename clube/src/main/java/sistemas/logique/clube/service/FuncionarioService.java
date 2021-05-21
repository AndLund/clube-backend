package sistemas.logique.clube.service;

import org.springframework.stereotype.Service;
import sistemas.logique.clube.model.Funcionario;
import sistemas.logique.clube.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario insert(Funcionario f){
        return funcionarioRepository.save(f);
    }

    public Funcionario update(Funcionario f) {
        return funcionarioRepository.save(f);
    }

    public void delete(Funcionario f){
        funcionarioRepository.delete(f);
    }

    public Funcionario getOne(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario saveAndFlush(Funcionario f){
        return funcionarioRepository.saveAndFlush(f);
    }

    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> getAll(){
        return funcionarioRepository.findAll();
    }
}
