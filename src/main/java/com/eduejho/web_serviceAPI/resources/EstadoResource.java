package com.eduejho.web_serviceAPI.resources;

import com.eduejho.web_serviceAPI.entities.Endereco;
import com.eduejho.web_serviceAPI.entities.Estado;
import com.eduejho.web_serviceAPI.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> findAll(){
        List<Estado> lista = estadoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Long id){
        Estado obj = estadoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado create(@RequestBody Estado obj){
        return estadoService.create(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        estadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
