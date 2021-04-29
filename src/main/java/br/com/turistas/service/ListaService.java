package br.com.turistas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.turistas.dto.PerfilDTO;
import br.com.turistas.repository.PerfilRepository;

@Service
public class ListaService {



  @Autowired
  PerfilRepository perfilRepository;

  public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
  }



  public List<PerfilDTO> listarPerfils(String nomePerfil) {

    List<PerfilDTO> result = new ArrayList<PerfilDTO>();

    if (nomePerfil == null || nomePerfil.isBlank()) {

      var dados = perfilRepository.findAll();
      result.addAll(dados.stream().map(x -> {
        return new PerfilDTO(x.getPerfil().trim());
      }).collect(Collectors.toList()));

    } else {

      var dado = perfilRepository.findByPerfil(nomePerfil);
      if (dado.isPresent()) {
        result.add(new PerfilDTO(dado.get().getPerfil().trim()));

      } else {
        result.add(new PerfilDTO(null));
      }
    }
    return result;
  }



}
