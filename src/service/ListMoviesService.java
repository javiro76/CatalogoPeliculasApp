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
        movies.forEach(System.out::println);
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
        System.out.println("Pelicula encontrada en el indice: " + index);
    }
}
