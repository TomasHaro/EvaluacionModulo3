package ar.com.vates.abmlibros.repositories;

import ar.com.vates.abmlibros.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<Autor, Integer> {

    Autor getAutorByNombreContainingIgnoreCase(String nombre);

}
