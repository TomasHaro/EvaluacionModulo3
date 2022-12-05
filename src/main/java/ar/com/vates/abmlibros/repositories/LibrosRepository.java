package ar.com.vates.abmlibros.repositories;

import ar.com.vates.abmlibros.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {

    List<Libro> getAllByOrderByTitulo();

    int countLibrosByIdAutor(int idAutor);

    List<Libro> getAllByTituloContainingIgnoreCase(String titulo);

    List<Libro> getAllByIdAutor(int id);


}
