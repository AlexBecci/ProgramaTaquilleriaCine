package arg.com.peliculas.negocio;

import arg.com.peliculas.datos.AccesoDatosImpl;
import arg.com.peliculas.datos.IAccesoDatos;
import arg.com.peliculas.domain.Pelicula;
import arg.com.peliculas.excepciones.AccesoDatosEx;
import arg.com.peliculas.excepciones.LecturaDatosEx;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogoPeliculasImplementacion implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImplementacion() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPeliculas(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de accesos a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {

        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPeliculas(String buscar) {

        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar el catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }

}
