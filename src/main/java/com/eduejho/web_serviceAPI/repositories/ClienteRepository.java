package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
