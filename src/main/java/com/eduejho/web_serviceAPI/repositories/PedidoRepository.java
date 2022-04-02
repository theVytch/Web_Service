package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
