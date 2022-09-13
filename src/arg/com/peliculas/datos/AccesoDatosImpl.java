package arg.com.peliculas.datos;

import arg.com.peliculas.domain.Pelicula;
import arg.com.peliculas.excepciones.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            try {
                linea = entrada.readLine();
                while (linea != null) {
                    Pelicula pelicula = new Pelicula(linea);
                    peliculas.add(pelicula);
                    linea = entrada.readLine();
                }
                entrada.close();

            } catch (IOException ex) {
                ex.printStackTrace();
                throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo: " + pelicula);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            try {
                linea = entrada.readLine();
                var indice = 1;
                while (linea != null) {
                    if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                        resultado = "Pelicula : " + linea + " Encontrada en el indice: " + indice;
                        break;
                    }
                    linea = entrada.readLine();
                    indice++;
                }
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo: " + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");

    }

}
