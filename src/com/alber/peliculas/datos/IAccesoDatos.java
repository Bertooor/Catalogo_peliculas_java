package com.alber.peliculas.datos;

import com.alber.peliculas.dominio.Pelicula;
import com.alber.peliculas.excepciones.AccesoDatosExcp;
import com.alber.peliculas.excepciones.EscrituraDatosExcp;
import com.alber.peliculas.excepciones.LecturaDatosExcp;
import java.util.List;

public interface IAccesoDatos {
    
    boolean existe (String nombreRecurso) throws AccesoDatosExcp;
    
    List<Pelicula> listar (String nombreRecurso) throws LecturaDatosExcp;
    
    void escribir (Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExcp;
    
    String buscar (String nombreRecurso, String buscar) throws LecturaDatosExcp;
    
    void crear (String nombreRecurso) throws AccesoDatosExcp;
    
    void borrar (String nombreRecurso) throws AccesoDatosExcp;
    
}
