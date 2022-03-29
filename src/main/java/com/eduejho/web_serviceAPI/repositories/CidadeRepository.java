package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
