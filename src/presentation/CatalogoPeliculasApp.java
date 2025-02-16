package presentation;

import dominio.Pelicula;
import service.IServiceMovies;
import service.ListMoviesService;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //Agregar Implementación del servicio
        IServiceMovies moviesService = new ListMoviesService();
        while (!salir){
            try{
                showMenu();
                salir = exuteOptions(consola, moviesService);

            }catch (Exception e){
                System.out.println("Ocurrió un error: " + e.getMessage());
            }

        System.out.println();
        }//fin while
    }
    private static void showMenu(){
        System.out.println("""
                *** Catalogo de Películas ***
                1. Agregar película
                2. Listar Peliculas
                3. Buscar Película
                4. Salir
                """);
    }

    private static boolean exuteOptions(Scanner consola, IServiceMovies moviesService){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                moviesService.addMovie(new Pelicula(nombrePelicula));
            }
            case 2 -> moviesService.listMovies();

            case 3 -> {
                System.out.println("Introduce la pelicula a buscar: ");
                var buscar = consola.nextLine();
                moviesService.searchMovie(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opción no recnocida: " + opcion );
        }

        return salir;
    }



}