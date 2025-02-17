package service;

import dominio.Pelicula;

import java.io.*;

public class ServiceMoviesFile implements IServiceMovies{

    private final String NAME_FILE = "peliculas.txt";

    public ServiceMoviesFile (){
        var file = new File(NAME_FILE);
        try {
            //si ya existe existe el archivo, No se vuelve a crear
            if(file.exists()){
                System.out.println("El archivo ya existe!");
            }
            else {
                //Si no existe, se crea vacio
                var salida = new PrintWriter(new FileWriter(file));
                //para guardar en DD se debe cerrar
                salida.close();
                System.out.println("Se ha creado el archivo");

            }

        } catch (Exception e){
            System.out.println("Ocurrio un error al abrir archivo: " + e.getMessage());
        }
    }

    @Override
    public void listMovies() {
        //volvemos abrir el archivo
        var file = new File(NAME_FILE);
        try {
            //abrimos  archivo para lectura
            var entrada = new BufferedReader(new FileReader(file));
            //leemos linea linea el archivo
            String linea;
            linea = entrada.readLine();
            //leemos todas la lineas
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de terminar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }
            // cerrar el archivo
            entrada.close();
        } catch (Exception e){
            System.out.println("Ocurrio un problema al leer el archivo: " + e.getMessage());
        }


    }

    @Override
    public void addMovie(Pelicula pelicula) {
        boolean anexar = false;
        var file = new File(NAME_FILE);
        try {
            //Revisar si existe el archivo
            anexar = file.exists();
            var salida = new PrintWriter(new FileWriter(file,anexar));
            //Agregamos la pelicula (toString)
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego al archivo: " + pelicula);

        } catch (Exception e){
            System.out.println("Ocurrió un error al agregar pelicula: " + e.getMessage());
        }
    }

    @Override
    public void searchMovie(Pelicula pelicula) {
        var archivo = new File(NAME_FILE);
        try {
            //Abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getName();
            while (lineaTexto != null){
                // Buscamos sin importar mayusculas o minusculas
                if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                //Leemos la siguiente linea antes de la siguiente iteracion
                lineaTexto = entrada.readLine();
                indice++;
            }// fin while
            //imprimimos los resultados de  la busqueda
            if(encontrada){
                System.out.println("Pelicula " + lineaTexto + "encontrada en la linea " + indice);
            }else {
                System.out.println("No se ha encontrado la pelicula: " + lineaTexto );
            }
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar en el archivo: " + e.getMessage());
        }
    }
}
