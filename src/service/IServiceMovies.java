package service;

import dominio.Pelicula;

public interface IServiceMovies {
    public void listMovies();
    public void addMovie(Pelicula pelicula);
    public void searchMovie(Pelicula pelicula);

}
