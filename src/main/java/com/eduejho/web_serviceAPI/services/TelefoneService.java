package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.Cliente;
import com.eduejho.web_serviceAPI.entities.Telefone;
import com.eduejho.web_serviceAPI.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public List<Telefone> findAll(){
        return telefoneRepository.findAll();
    }

    public Telefone findById(Long id){
        Optional<Telefone> obj = telefoneRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public Telefone create(Telefone obj) {
        return telefoneRepository.save(obj);
    }

    public void delete(Long id){
        telefoneRepository.deleteById(id);
    }
}
