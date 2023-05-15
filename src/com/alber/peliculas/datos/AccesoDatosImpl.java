package com.alber.peliculas.datos;

import com.alber.peliculas.dominio.Pelicula;
import com.alber.peliculas.excepciones.AccesoDatosExcp;
import com.alber.peliculas.excepciones.EscrituraDatosExcp;
import com.alber.peliculas.excepciones.LecturaDatosExcp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreRecurso) {
        
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcp {
        
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        
        try {
            
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            
            while(linea != null) {
                
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
                
            }
            
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            
            ex.printStackTrace();
            throw new LecturaDatosExcp("Excepción al listar películas: " + ex.getMessage());
            
        } catch (IOException ex) {
            
            throw new LecturaDatosExcp("Excepción al listar películas: " + ex.getMessage());
            
        }
        
        return peliculas;
        
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExcp {
        
        var archivo = new File(nombreRecurso);
        
        try {
            
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito información al archivo: " + pelicula);
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            throw new EscrituraDatosExcp("Excepción al escribir películas: " + ex.getMessage());
            
        }
        
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcp {
        
        var archivo = new File(nombreRecurso);
        String resultado = null;
        
        try {
            
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            
            while(linea != null) {
                
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    
                    resultado = "Película " + linea + " encontrada en el índice " + indice;
                    break;
                    
                }
                
                linea = entrada.readLine();
                indice++;
                
            }
            
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            
            ex.printStackTrace();
            throw new LecturaDatosExcp("Excepción al buscar películas: " + ex.getMessage());
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            throw new LecturaDatosExcp("Excepción al listar películas: " + ex.getMessage());
            
        }
        
        return resultado;
        
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosExcp {
        
        var archivo = new File(nombreRecurso);
        try {
            
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            throw new AccesoDatosExcp("Excepción al crear archivo: " + ex.getMessage());
            
        }
        
    }

    @Override
    public void borrar(String nombreRecurso){
        
        var archivo = new File(nombreRecurso);
        
        if (archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
        
    }
    
}
