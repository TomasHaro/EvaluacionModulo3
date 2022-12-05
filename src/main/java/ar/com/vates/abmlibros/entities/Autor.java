package ar.com.vates.abmlibros.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    private int id;

    @Basic
    private String nombre;

    public Autor() {
    }

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }
}
