package com.eduejho.web_serviceAPI.resources;

import com.eduejho.web_serviceAPI.entities.Categoria;
import com.eduejho.web_serviceAPI.entities.Cidade;
import com.eduejho.web_serviceAPI.services.CategoriaService;
import com.eduejho.web_serviceAPI.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> lista = categoriaService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody Categoria obj){
        return categoriaService.create(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
