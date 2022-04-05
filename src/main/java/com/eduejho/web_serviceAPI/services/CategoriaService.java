package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.Categoria;
import com.eduejho.web_serviceAPI.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public Categoria create(Categoria obj) {
        return categoriaRepository.save(obj);
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }
}
