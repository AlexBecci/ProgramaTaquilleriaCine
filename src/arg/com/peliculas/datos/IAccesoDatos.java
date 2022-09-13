package arg.com.peliculas.datos;

import arg.com.peliculas.domain.Pelicula;
import arg.com.peliculas.excepciones.*;
import java.util.List;

public interface IAccesoDatos {

    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    public void crear(String nombreRecurso) throws AccesoDatosEx;

    public void borrar(String nombreRecurso) throws AccesoDatosEx;
}
