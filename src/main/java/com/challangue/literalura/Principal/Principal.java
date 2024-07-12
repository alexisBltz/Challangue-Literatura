package com.challangue.literalura.Principal;

import java.net.URL;
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
        //Obtendremos la primera opcion del libro
        DatosLibro datosLibro = getDatosSerie().libro().get(0);
        Libro libro = new Libro(datosLibro);
        System.out.println(datosLibro);
        repository.save(libro);
    }

    private DatosResult getDatosSerie () {
        //Vamos a abordar el problema que de la url tengo que entrar a results

        System.out.println("Ingrese el libro que esta buscando");
        var libroBuscado = teclado.nextLine().toLowerCase().replace(" ", "%20");

        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + libroBuscado);
        //System.out.println("URL BASE: "+URL_BASE+"?search="+libroBuscado);

        DatosResult datos = conversor.obtenerDatos(json, DatosResult.class);
        //System.out.println(datos.libro());
        return datos;
    }


}


