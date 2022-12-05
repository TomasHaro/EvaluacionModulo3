package ar.com.vates.abmlibros.services;

import ar.com.vates.abmlibros.entities.Autor;
import ar.com.vates.abmlibros.entities.Libro;
import ar.com.vates.abmlibros.repositories.AutoresRepository;
import ar.com.vates.abmlibros.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.Collection;

@Service
@ApplicationScope
public class ReportesService {

    @Autowired
    private AutoresRepository autoresRepo;

    @Autowired
    private LibrosRepository librosRepo;

    // Reportes

    public Collection<Libro> buscarTodosOrdenadosPorTitulo(){ return librosRepo.getAllByOrderByTitulo();}

    public int contarLibrosDeAutor(int id){ return librosRepo.countLibrosByIdAutor(id);}

    public Collection<Libro> buscarPorTitulo(String titulo){ return librosRepo.getAllByTituloContainingIgnoreCase(titulo);}

    public Collection<Libro> buscarPorNombreAutor(String nom){

        Autor autor = autoresRepo.getAutorByNombreContainingIgnoreCase(nom);
        if (autor != null){
            return librosRepo.getAllByIdAutor(autor.getId());
        }
        else{
            return new ArrayList<>();
        }

    }

}