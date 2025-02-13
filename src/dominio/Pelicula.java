package dominio;

import java.util.Objects;

public class Pelicula {
    private String name;

    public Pelicula () {};
    public Pelicula (String name) {
        this.name = name;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(name, pelicula.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Pelicula pelicula_1 = new Pelicula("batman");
        Pelicula pelicula_2 = new Pelicula("superman");
        System.out.println(pelicula_1);
        System.out.println(pelicula_2);

    }
}
