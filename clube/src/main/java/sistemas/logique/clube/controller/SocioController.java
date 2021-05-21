package sistemas.logique.clube.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistemas.logique.clube.model.Socio;
import sistemas.logique.clube.service.SocioService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/socio")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class SocioController {

    private SocioService service;

    public SocioController(SocioService service) {
        this.service = service;
    }

    @PostMapping
    public Socio insert(@RequestBody Socio s){
        return service.insert(s);
    }

    @GetMapping
    public List<Socio> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Socio> getOne(@PathVariable("id") Long id){
        Optional<Socio> socioOptional = service.findById(id);

        if(socioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            Socio socio = socioOptional.get();
            //mim mesmo
            socio.add(linkTo(SocioController.class).slash(id).withSelfRel());
            //para todos
            socio.add(linkTo(SocioController.class).withRel("all-socios"));

            return ResponseEntity.ok().body(socio);
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Socio> update(@PathVariable Long id, @RequestBody Socio s){
        return service
                .findById(id)
                .map(record -> {
                    service.saveAndFlush(s);
                    return ResponseEntity.ok().body(s);
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
