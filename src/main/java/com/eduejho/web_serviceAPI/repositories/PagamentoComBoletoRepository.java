package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.PagamentoComBoleto;

import javax.transaction.Transactional;

@Transactional
public interface PagamentoComBoletoRepository extends PagamentoRepository<PagamentoComBoleto>{
}
