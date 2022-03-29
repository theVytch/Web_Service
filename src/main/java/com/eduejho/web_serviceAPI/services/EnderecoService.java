package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.Cliente;
import com.eduejho.web_serviceAPI.entities.Endereco;
import com.eduejho.web_serviceAPI.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public Endereco findById(Long id){
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public Endereco create(Endereco obj) {
        return enderecoRepository.save(obj);
    }

    public void delete(Long id){
        enderecoRepository.deleteById(id);
    }
}
