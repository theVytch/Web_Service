package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.PagamentoComCartao;
import com.eduejho.web_serviceAPI.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoComCartaoService {

    @Autowired
    private PagamentoRepository<PagamentoComCartao> pagamentoCartaoRepository;

    public List<PagamentoComCartao> findAll(){
        return pagamentoCartaoRepository.findAll();
    }

    public PagamentoComCartao findById(Long id){
        Optional<PagamentoComCartao> obj = pagamentoCartaoRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }


    public PagamentoComCartao create(PagamentoComCartao obj) {
        return pagamentoCartaoRepository.save(obj);
    }

    public void delete(Long id){
        pagamentoCartaoRepository.deleteById(id);
    }

}
