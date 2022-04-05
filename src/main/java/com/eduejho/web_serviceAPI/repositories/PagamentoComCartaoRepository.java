package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.PagamentoComCartao;

import javax.transaction.Transactional;

@Transactional
public interface PagamentoComCartaoRepository extends PagamentoRepository<PagamentoComCartao>{


}
