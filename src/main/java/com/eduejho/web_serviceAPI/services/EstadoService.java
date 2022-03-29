package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.Cliente;
import com.eduejho.web_serviceAPI.entities.Estado;
import com.eduejho.web_serviceAPI.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    public Estado findById(Long id){
        Optional<Estado> obj = estadoRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public Estado create(Estado obj) {
        return estadoRepository.save(obj);
    }

    public void delete(Long id){
        estadoRepository.deleteById(id);
    }
}
