package com.eduejho.web_serviceAPI.services;

import com.eduejho.web_serviceAPI.entities.PagamentoComBoleto;
import com.eduejho.web_serviceAPI.entities.PagamentoComCartao;
import com.eduejho.web_serviceAPI.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoComBoletoService {

    @Autowired
    private PagamentoRepository<PagamentoComBoleto> pagamentoBoletoRepository;

    public List<PagamentoComBoleto> findAll(){
        return pagamentoBoletoRepository.findAll();
    }

    public PagamentoComBoleto findById(Long id){
        Optional<PagamentoComBoleto> obj = pagamentoBoletoRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalStateException(id+" não encontrado"));
    }

    public PagamentoComBoleto create(PagamentoComBoleto obj) {
        return pagamentoBoletoRepository.save(obj);
    }

    public void delete(Long id){
        pagamentoBoletoRepository.deleteById(id);
    }

}
