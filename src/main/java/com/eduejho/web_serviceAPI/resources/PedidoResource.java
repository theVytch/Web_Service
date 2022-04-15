package com.eduejho.web_serviceAPI.resources;

import com.eduejho.web_serviceAPI.entities.Pedido;
import com.eduejho.web_serviceAPI.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> lista = pedidoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido obj = pedidoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido create(@RequestBody Pedido obj){
        return pedidoService.create(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/filter")
    public ResponseEntity<List<Pedido>> findById(@RequestParam(value = "cpfOuCnpj", required = false, defaultValue = "") String cpfOuCnpj){
        List<Pedido> lista = pedidoService.findByCpfOuCnpjCliente(cpfOuCnpj);
        return ResponseEntity.ok().body(lista);
    }
}
