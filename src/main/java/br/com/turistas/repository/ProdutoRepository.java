package br.com.turistas.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.turistas.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {

  List<ProdutoModel> findByNomeContaining(String nomeProduto);

  Optional<ProdutoModel> findByNome(String nomeProduto);

  void deleteByNome(String nomeProduto);

}
