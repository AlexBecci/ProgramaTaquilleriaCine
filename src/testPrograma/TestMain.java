package testPrograma;

import arg.com.peliculas.negocio.CatalogoPeliculasImplementacion;
import arg.com.peliculas.negocio.*;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImplementacion();

        while (opcion != 0) {
            System.out.println("Elige una opcion\n"
                    + "1.-Iniciar Catalogo de peliculas\n"
                    + "2.-Agregar pelicula\n"
                    + "3.-Listar peliculas\n"
                    + "4.-Buscar pelicula\n"
                    + "0.-Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPeliculas(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                case 4:
                    System.out.println("Introduce una pelicula a buscar");
                    var buscar = scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion no correspondiente");
                    break;
            }
        }
    }

//public static void eleccionOpciones(int opcion) {
//        String nombreArchivo = "Peliculas.txt";
//
//        if (opcion == 1) {
//            System.out.println("Iniciando catalogo de peliculas");
//            System.out.println("Introduce del catalogo(archivo): ");
//            Scanner scanNombreArchivo = new Scanner(System.in);
//            nombreArchivo = scanNombreArchivo.nextLine();
//            CatalogoPeliculasImplementacion opcionPelicula1 = new CatalogoPeliculasImplementacion();
//            opcionPelicula1.iniciarArchivo(nombreArchivo + ".txt");
//        } else if (opcion == 2) {
//            System.out.println("Introduce el nombre de la pelicula a agregar: ");
//            Scanner scanNombrePelicula = new Scanner(System.in);
//            String nombrePelicula = scanNombrePelicula.nextLine();
//            CatalogoPeliculasImplementacion opcionPelicula2 = new CatalogoPeliculasImplementacion();
//            opcionPelicula2.agregarPeliculas(nombreArchivo, nombrePelicula);
//        } else if (opcion == 3) {
//            CatalogoPeliculasImplementacion opcionPelicula3 = new CatalogoPeliculasImplementacion();
//            opcionPelicula3.listarPeliculas(nombreArchivo);
//        }
//    }
}
