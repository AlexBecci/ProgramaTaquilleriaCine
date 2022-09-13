package arg.com.peliculas.negocio;

public interface ICatalogoPeliculas {

    String NOMBRE_RECURSO = "peliculas.txt";

    public void agregarPeliculas(String nombrePelicula);

    public void listarPeliculas();

    public void buscarPeliculas(String buscar);

    public void iniciarCatalogoPeliculas();

}
