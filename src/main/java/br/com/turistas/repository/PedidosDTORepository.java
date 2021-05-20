package br.com.turistas.repository;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.turistas.dto.PedidoDTO;

@Repository
public class PedidosDTORepository {

  private static final String CONST_USUARIO = "COD_USUARIO";

  @Autowired
  EntityManager entityManager;


  @SuppressWarnings("unchecked")
  public ArrayList<PedidoDTO> getPedidos(Integer codUsuario) {
    var pedidos = new ArrayList<PedidoDTO>();

    try {

      pedidos = (ArrayList<PedidoDTO>) entityManager
          .createStoredProcedureQuery("usp_lista_pedidos", "PedidoDTOInfo")
          .registerStoredProcedureParameter(CONST_USUARIO, Integer.class, ParameterMode.IN)
          .setParameter(CONST_USUARIO, codUsuario).getResultList();

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    return pedidos;
  }
}
