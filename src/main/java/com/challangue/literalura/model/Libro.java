package com.challangue.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Libro {
    private String id;
    private String titulo;
    private List<DatosAutor> autores;
}
