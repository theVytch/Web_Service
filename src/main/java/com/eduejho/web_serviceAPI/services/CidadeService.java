package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.Cidade;
import com.eduejho.web_serviceAPI.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    public Cidade findById(Long id){
        Optional<Cidade> obj = cidadeRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public Cidade create(Cidade obj) {
        return cidadeRepository.save(obj);
    }

    public void delete(Long id){
        cidadeRepository.deleteById(id);
    }
}
