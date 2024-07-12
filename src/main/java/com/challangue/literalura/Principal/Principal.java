package com.challangue.literalura.Principal;

import java.util.Optional;
import java.util.Scanner;

import com.challangue.literalura.model.DatosLibro;
import com.challangue.literalura.model.DatosResult;
import com.challangue.literalura.model.Libro;
import com.challangue.literalura.repository.LibroRepository;
import com.challangue.literalura.services.ConsumirAPI;
import com.challangue.literalura.services.ConvierteDatos;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumirAPI consumoApi = new ConsumirAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibroRepository repository;
    private Optional<Libro> libroBuscado;

    public Principal(LibroRepository repository) {
        this.repository = repository;
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
            }


        }
    }
    private void buscarLibro() {
        DatosLibro datosLibro = getDatosLibro();
        if (datosLibro == null) {
            System.out.println("No se encontró el libro.");
            return;
        }

        Libro libroBuscado = new Libro(datosLibro);
        System.out.println(libroBuscado);
        repository.save(libroBuscado);
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


