package ar.com.vates.abmlibros.services;

import ar.com.vates.abmlibros.entities.Autor;
import ar.com.vates.abmlibros.repositories.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Collection;

@Service
@ApplicationScope
public class AutoresService {

    @Autowired
    private AutoresRepository repo;

    public void guardar(Autor nuevo) { repo.save(nuevo); }

    public Autor buscarPorId(int id) { return repo.findById(id).orElse(null); }

    public void borrar(int id) { repo.deleteById(id); }

    public Collection<Autor> buscarTodos() { return repo.findAll(); }

}
