package sistemas.logique.clube.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemas.logique.clube.model.Funcionario;
import sistemas.logique.clube.service.FuncionarioService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class FuncionarioController {

    private FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping
    public Funcionario insert(@RequestBody Funcionario f){
        return service.insert(f);
    }

    @GetMapping
    public List<Funcionario> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Funcionario> getOne(@PathVariable("id") Long id){
        Optional<Funcionario> funcionarioOptional = service.findById(id);

        if(funcionarioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            Funcionario funcionario = funcionarioOptional.get();
            //mim mesmo
            funcionario.add(linkTo(FuncionarioController.class).slash(id).withSelfRel());
            //para todos
            funcionario.add(linkTo(FuncionarioController.class).withRel("all-funcionarios"));

            return ResponseEntity.ok().body(funcionario);
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario f){
        return service
                .findById(id)
                .map(record -> {
                    service.saveAndFlush(f);
                    return ResponseEntity.ok().body(f);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
                .findById(id)
                .map(record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
