package br.com.turistas.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.turistas.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

  Optional<UsuarioModel> findByNome(String nomeUsuario);

  Optional<UsuarioModel> findByEmail(String email);

  List<UsuarioModel> findByCodPerfil(Integer codPerfil);

  Optional<UsuarioModel> findByCodUsuario(Integer codUsuario);


}
