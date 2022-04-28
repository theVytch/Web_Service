package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.ItemPedido;
import com.eduejho.web_serviceAPI.entities.Pedido;
import com.eduejho.web_serviceAPI.repositories.ItemPedidoRepository;
import com.eduejho.web_serviceAPI.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id){
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public Pedido create(Pedido obj) {
        return pedidoRepository.save(obj);
    }

    public void delete(Long id){
        pedidoRepository.deleteById(id);
    }

    public List<Pedido> findByCpfOuCnpjCliente(String cpfOuCnpj){
        return pedidoRepository.findByCpfOuCnpjCliente(cpfOuCnpj);
    }

    public List<ItemPedido> findItemPedidoByIdPedido(Long id){
        return itemPedidoRepository.findItemPedidoByIdPedido(id);
    }
}
