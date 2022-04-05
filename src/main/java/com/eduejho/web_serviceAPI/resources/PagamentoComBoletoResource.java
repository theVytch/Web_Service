package com.eduejho.web_serviceAPI.resources;

import com.eduejho.web_serviceAPI.entities.PagamentoComBoleto;
import com.eduejho.web_serviceAPI.services.PagamentoComBoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boleto")
public class PagamentoComBoletoResource {

    @Autowired
    private PagamentoComBoletoService pagamentoBoletoService;

    @GetMapping
    public ResponseEntity<List<PagamentoComBoleto>> findAll(){
        List<PagamentoComBoleto> lista = pagamentoBoletoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoComBoleto> findById(@PathVariable Long id){
        PagamentoComBoleto obj = pagamentoBoletoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoComBoleto create(@RequestBody PagamentoComBoleto obj){
        return pagamentoBoletoService.create(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pagamentoBoletoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
