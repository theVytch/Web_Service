package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.Pagamento;
import com.eduejho.web_serviceAPI.entities.PagamentoComCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PagamentoRepository<T extends Pagamento> extends JpaRepository<T, Long>{

}
