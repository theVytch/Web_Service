package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.Cidade;
import com.eduejho.web_serviceAPI.entities.Cliente;
import com.eduejho.web_serviceAPI.repositories.ClienteRepository;
import com.eduejho.web_serviceAPI.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public Cliente create(Cliente obj) {
        return clienteRepository.save(obj);
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente update(Long id, Cliente obj) {
        try {
            Cliente entity = clienteRepository.getById(id);
            updateData(entity, obj);
            return clienteRepository.save(entity);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Cliente entity, Cliente obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setCpfOuCnpj(obj.getCpfOuCnpj());
    }
}
