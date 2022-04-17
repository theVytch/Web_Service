package com.eduejho.web_serviceAPI.repositories;

import com.eduejho.web_serviceAPI.entities.Cliente;
import com.eduejho.web_serviceAPI.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    //http://localhost:8080/pedidos/filter?cpfOuCnpj=12378945684
    @Query("select s from Pedido s join s.cliente c " +
            "where upper(c.cpfOuCnpj) like upper (:cpfOuCnpj)")
    List<Pedido> findByCpfOuCnpjCliente(@Param("cpfOuCnpj") String cpfOuCnpj);

}
