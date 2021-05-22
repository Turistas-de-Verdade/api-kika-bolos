package br.com.turistas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.turistas.model.DuvidaModel;

@Repository
public interface DuvidaRepository extends JpaRepository<DuvidaModel, Integer> {

  List<DuvidaModel> findByTituloContaining(String titulo);

  void deleteByNomeUsuario(String nomeUsuario);

}
