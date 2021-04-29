package br.com.turistas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.turistas.model.PerfilModel;

public interface PerfilRepository extends JpaRepository<PerfilModel, Integer> {

  Optional<PerfilModel> findByPerfil(String nome);

  Optional<PerfilModel> deleteByPerfil(String nome);

}
