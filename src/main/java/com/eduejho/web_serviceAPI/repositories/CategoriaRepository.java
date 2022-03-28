package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
