package service;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ListMoviesService implements IServiceMovies {

    private final List<Pelicula> movies;

    public ListMoviesService(){
        this.movies = new ArrayList<>();
    }

    @Override
    public void listMovies() {
        System.out.println("Listado de peliculas...");
        //movies.forEach(System.out::println);
        movies.forEach((movie)-> System.out.println(movie.getName()));
    }

    @Override
    public void addMovie(Pelicula pelicula) {
        movies.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void searchMovie(Pelicula pelicula) {
        //Regresa el indice de la pelicula encontrada en la lista
        var index = movies.indexOf(pelicula);
        if(index == -1){
            System.out.println("No se encontro la pelicula: " + pelicula);
        }else {
            System.out.println("Pelicula: " + pelicula.getName() + " encontrada en el indice: " + index);
        }
    }

    public static void main(String[] args) {
        Pelicula pelicula_1 = new Pelicula("Batman");
        Pelicula pelicula_2 = new Pelicula("Superman");

        // Implementar el servicio, izquierda la interface, derecha el servicio
        IServiceMovies moviesService = new ListMoviesService();

        // Agregar peliculas al servicio
        moviesService.addMovie(pelicula_1);
        moviesService.addMovie(pelicula_2);

        //listar peliculas
        moviesService.listMovies();

        //buscar peliculas
        moviesService.searchMovie(pelicula_1);
        moviesService.searchMovie(new Pelicula("Transformes"));
    }
}
