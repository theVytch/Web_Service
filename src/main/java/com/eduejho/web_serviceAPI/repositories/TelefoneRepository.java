package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
