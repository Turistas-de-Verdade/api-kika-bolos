package br.com.turistas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.turistas.model.PedidoModel;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

  Optional<PedidoModel> findByCodPedido(Integer codPedido);



}
