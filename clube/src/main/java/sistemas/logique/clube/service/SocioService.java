package sistemas.logique.clube.service;

import org.springframework.stereotype.Service;
import sistemas.logique.clube.model.Socio;
import sistemas.logique.clube.repository.SocioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {

    private SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public Socio insert(Socio s){
        return socioRepository.save(s);
    }

    public Socio update(Socio s) {
        return socioRepository.save(s);
    }

    public void delete(Socio s){
        socioRepository.delete(s);
    }

    public Socio getOne(Long id){
        return socioRepository.findById(id).orElse(null);
    }

    public Socio saveAndFlush(Socio s){
        return socioRepository.saveAndFlush(s);
    }

    public Optional<Socio> findById(Long id) {
        return socioRepository.findById(id);
    }

    public List<Socio> getAll(){
        return socioRepository.findAll();
    }
}
