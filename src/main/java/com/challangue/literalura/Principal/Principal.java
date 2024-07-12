package com.challangue.literalura.Principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.challangue.literalura.model.*;
import com.challangue.literalura.repository.AutorRepository;
import com.challangue.literalura.repository.LibroRepository;
import com.challangue.literalura.services.ConsumirAPI;
import com.challangue.literalura.services.ConvierteDatos;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumirAPI consumoApi = new ConsumirAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibroRepository libroRepository;
    private AutorRepository autorRepository;
    private Optional<Libro> libroBuscado;

    public Principal(LibroRepository repository, AutorRepository repository2) {
        this.libroRepository = repository;
        this.autorRepository= repository2;
    }

    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                case 2:
                    mostrarTodosLibros();
                case 3:
                    mostrarAutoresRegistrados();
                case 4:
                    mostrarVivos();
                case 5:
                    obtenerLibrosIdioma();

            }


        }
    }

    public void obtenerLibrosIdioma() {
        System.out.println("Ingrese el idioma que desea listar (es/en): ");
        var idioma = teclado.nextLine();

        try {
            Lenguaje idiomaLenguaje = Lenguaje.fromString(idioma);
            List<Libro> librosEnIdioma = libroRepository.obtenerIdiomas(idiomaLenguaje);

            if (librosEnIdioma.isEmpty()) {
                System.out.println("No se encontraron libros en el idioma " + idiomaLenguaje);
            } else {
                System.out.println("Libros en el idioma " + idiomaLenguaje + ":");
                for (Libro libro : librosEnIdioma) {
                    System.out.println(libro.getTitulo());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Idioma no válido. Por favor, ingrese 'es' para español o 'en' para inglés.");
        }
    }

    private void mostrarVivos() {
        System.out.println("Ingrese el año de búsqueda:");
        var añoBusqueda = teclado.nextLine();
        List<Autor> autoresVivos = autorRepository.obtenerVivosPorAño(añoBusqueda);

        if (autoresVivos.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año " + añoBusqueda);
        } else {
            System.out.println("Autores vivos en el año " + añoBusqueda + ":");
            for (Autor autor : autoresVivos) {
                System.out.println(autor.getNombreAutor());
            }
        }
    }

    private void mostrarAutoresRegistrados(){
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    private void mostrarTodosLibros(){
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }
    private void buscarLibro() {
        DatosLibro datosLibro = getDatosLibro();
        if (datosLibro == null) {
            System.out.println("No se encontró el libro.");
            return;
        }

        Libro libroBuscado = new Libro(datosLibro);
        System.out.println(libroBuscado);
        libroRepository.save(libroBuscado);
    }

    private DatosLibro getDatosLibro() {
        System.out.println("Ingrese el libro que está buscando");
        var libroBuscado = teclado.nextLine().toLowerCase().replace(" ", "%20");

        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + libroBuscado);
        // los resultados
        DatosResult datos = conversor.obtenerDatos(json, DatosResult.class);
        // verificar si hay libros en la lista uwu
        if (datos.libro() == null || datos.libro().isEmpty()) {
            return null;
        }
        // escogemos el primero
        return datos.libro().get(0);
    }


}


