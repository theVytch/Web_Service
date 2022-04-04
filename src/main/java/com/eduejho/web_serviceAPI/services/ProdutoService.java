package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.Produto;
import com.eduejho.web_serviceAPI.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public Produto create(Produto obj) {
        return produtoRepository.save(obj);
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }
}
