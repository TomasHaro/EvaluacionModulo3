package ar.com.vates.abmlibros.services;

import ar.com.vates.abmlibros.entities.Libro;
import ar.com.vates.abmlibros.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Collection;
import java.util.Collections;

@Service
@ApplicationScope
public class LibrosService {

    @Autowired
    private LibrosRepository repo;


    public void guardar(Libro nuevo) { repo.save(nuevo); }

    public Libro buscarPorId(int id) { return repo.findById(id).orElse(null); }

    public void borrar(int id) { repo.deleteById(id); }

    public Collection<Libro> buscarTodos() { return repo.findAll(); }
}
