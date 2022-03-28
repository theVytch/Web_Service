package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
