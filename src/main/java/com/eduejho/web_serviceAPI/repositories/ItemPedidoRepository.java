package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.ItemPedido;
import com.eduejho.web_serviceAPI.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    @Query("select s from ItemPedido s where pedido_id = :id ")
    List<ItemPedido> findByIdPedido(@Param("id") Long id);
}
