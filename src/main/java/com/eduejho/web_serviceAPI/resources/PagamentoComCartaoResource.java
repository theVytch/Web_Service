package com.eduejho.web_serviceAPI.resources;

import com.eduejho.web_serviceAPI.entities.PagamentoComCartao;
import com.eduejho.web_serviceAPI.services.PagamentoComCartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class PagamentoComCartaoResource {

    @Autowired
    private PagamentoComCartaoService pagamentoCartaoService;

    @GetMapping
    public ResponseEntity<List<PagamentoComCartao>> findAll(){
        List<PagamentoComCartao> lista = pagamentoCartaoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoComCartao> findById(@PathVariable Long id){
        PagamentoComCartao obj = pagamentoCartaoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoComCartao create(@RequestBody PagamentoComCartao obj){
        return pagamentoCartaoService.create(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pagamentoCartaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
