package com.challangue.literalura.Principal;

import java.net.URL;
import java.util.Scanner;

import com.challangue.literalura.model.DatosLibro;
import com.challangue.literalura.model.DatosResult;
import com.challangue.literalura.services.ConsumirAPI;
import com.challangue.literalura.services.ConvierteDatos;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumirAPI consumoApi = new ConsumirAPI();
    private final String URL_BASE = "https://gutendex.com/books/" +
            "" +
            "" +
            "";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mostrarMenu() {
        //getDatosSerie();
        System.out.println("Ingrese el libro que esta buscando");
        var libroBuscado = teclado.nextLine().toLowerCase().replace(" ","%20");
        System.out.println("nombre dle libro es: "+ libroBuscado);

        String json =consumoApi.obtenerDatos(URL_BASE+"?search="+libroBuscado);
        System.out.println("URL BASE: "+URL_BASE+"?search="+libroBuscado);


        DatosResult datos = conversor.obtenerDatos(json, DatosResult.class);
        System.out.println(datos);


    }
    private DatosResult getDatosSerie(){
        //Vamos a abordar el problema que de la url tengo que entrar a results

        System.out.println("Ingrese el libro que esta buscando");
        var libroBuscado = teclado.nextLine().toLowerCase().replace(" ","%20");
        System.out.println("nombre dle libro es: "+ libroBuscado);

        var json =consumoApi.obtenerDatos(URL_BASE+"?search="+libroBuscado);
        System.out.println("URL BASE: "+URL_BASE+"?search="+libroBuscado);


        DatosResult datos = conversor.obtenerDatos(json, DatosResult.class);
        System.out.println(datos.libro());
        return datos;
    }
}
