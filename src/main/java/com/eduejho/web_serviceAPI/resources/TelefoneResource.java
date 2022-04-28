package com.eduejho.web_serviceAPI.resources;

import com.eduejho.web_serviceAPI.entities.Endereco;
import com.eduejho.web_serviceAPI.entities.Estado;
import com.eduejho.web_serviceAPI.entities.Telefone;
import com.eduejho.web_serviceAPI.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneResource {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public ResponseEntity<List<Telefone>> findAll(){
        List<Telefone> lista = telefoneService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telefone> findById(@PathVariable Long id){
        Telefone obj = telefoneService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public Telefone create(@RequestBody Telefone obj){
        return telefoneService.create(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        telefoneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
