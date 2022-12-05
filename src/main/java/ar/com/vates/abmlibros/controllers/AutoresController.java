package ar.com.vates.abmlibros.controllers;

import ar.com.vates.abmlibros.entities.Autor;
import ar.com.vates.abmlibros.entities.Libro;
import ar.com.vates.abmlibros.repositories.LibrosRepository;
import ar.com.vates.abmlibros.services.AutoresService;
import ar.com.vates.abmlibros.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutoresController {

    @Autowired
    private LibrosRepository librosRepo;
    @Autowired
    private AutoresService autoresService;

    @Autowired
    private LibrosService librosService;

    //agregar un autor
    @PutMapping("/{id}")
    public ResponseEntity guardar (@RequestBody Autor nuevo){
        if(nuevo != null && nuevo.getNombre() != null){
            autoresService.guardar(nuevo);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity("Datos invalidos", HttpStatus.BAD_REQUEST);
        }
    }

    //borrar un autor
    @DeleteMapping("/{id}")
    public ResponseEntity borrar (@PathVariable int id) {
        Autor autor = autoresService.buscarPorId(id);
        if (autor != null) {
            List<Libro> libros = librosRepo.getAllByIdAutor(autor.getId());
            for (Libro libro: libros) {
                librosService.borrar(libro.getId());
            }
            autoresService.borrar(id);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //buscar todas
    @GetMapping("/")
    public Collection<Autor> consultarTodas(){return autoresService.buscarTodos();}

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable int id){
        Autor encontrado = autoresService.buscarPorId(id);
        if (encontrado != null){
            return ResponseEntity.ok(encontrado);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
