package com.eduejho.web_serviceAPI.resources;

import com.eduejho.web_serviceAPI.entities.Endereco;
import com.eduejho.web_serviceAPI.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> lista = enderecoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id){
        Endereco obj = enderecoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco create(@RequestBody Endereco obj){
        return enderecoService.create(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
