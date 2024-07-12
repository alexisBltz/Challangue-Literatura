package com.challangue.literalura.model;

public enum Lenguaje {
    ESPAÑOL("es","español"),
    INGLES("en", "ingles"),;

    private String lenguajeGutendex;
    private String lenguajeEspañol;

    Lenguaje(String lenguajeGutendex, String lenguajeEspañol){
        this.lenguajeEspañol = lenguajeEspañol;
        this.lenguajeGutendex = lenguajeGutendex;
    }

}
