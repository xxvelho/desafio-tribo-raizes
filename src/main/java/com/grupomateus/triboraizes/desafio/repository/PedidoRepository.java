package com.grupomateus.triboraizes.desafio.repository;

import com.grupomateus.triboraizes.desafio.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
