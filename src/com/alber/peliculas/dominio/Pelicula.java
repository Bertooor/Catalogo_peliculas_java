package com.alber.peliculas.dominio;

public class Pelicula {
    String nombre;
    
    /**
     * ###################
     * ## Constructores ##
     * ###################
     */

    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * #######################
     * ## Getters y Setters ##
     * #######################
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * #############
     * ## Métodos ##
     * #############
     */

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
