package ar.com.vates.abmlibros.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    private int id;

    @Basic
    private String titulo;

    @Column(name = "id_autor")
    private int idAutor;

    public Libro() {
    }

    public Libro(int id, String titulo, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.idAutor = idAutor;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getIdAutor() { return idAutor; }

    public void setIdAutor(int idAutor) { this.idAutor = idAutor; }
}
