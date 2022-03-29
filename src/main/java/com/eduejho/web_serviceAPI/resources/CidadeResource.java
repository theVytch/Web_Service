package com.eduejho.web_serviceAPI.resources;

import com.eduejho.web_serviceAPI.entities.Cidade;
import com.eduejho.web_serviceAPI.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<Cidade>> findAll(){
        List<Cidade> lista = cidadeService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Long id){
        Cidade obj = cidadeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade create(@RequestBody Cidade obj){
        return cidadeService.create(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
